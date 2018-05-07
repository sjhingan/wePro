package com.ip.wePro.project;


import com.ip.wePro.Notification.NotificationService;
import com.ip.wePro.assessment_status.Assessment_statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a service class which acts as a intermediate between the controller and the repository.
 * Controller will call the method in the service class to get the information as per rest call.
 * The service will invoke the repository methods which will fetch from the database and return the result.
 */
@Service
public class ProjectService {

    private static final Logger logger = Logger.getLogger("ProjectService");

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectSkillsRepository projectSkillsRepository;

    @Autowired
    Assessment_statusRepository assessmentStatusRepository;

    @Autowired
    NotificationService notificationService;

    /**
     * Get all project
     * @param pageable
     * @return list of projects
     */
    public Page<Project> getAllProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    /**
     * Add new project
     * @param project project object.
     */
    public void addProject(Project project) {
        if(project.getAssessmentRequired().equals("Yes")){
            project.setStatusId(ProjectStatus.SAVED.value());
        }else{
            project.setStatusId(ProjectStatus.OPEN.value());
        }
        projectRepository.save(project);

//        try {
//            notificationService.sendNotificationForProject(project);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            logger.log(Level.SEVERE, "Error in sending notification for matching skills: ");
//        }
    }

    /**
     * Get the project by project id.
     * @param id project id
     * @return
     */
    public Project getProject(int id) {
        return projectRepository.findById(id).get();
    }

    /**
     * Delete the project by project id
     * @param id project id
     */
    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }

    /**
     * Update the project information.
     * @param project updated project object.
     */
    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    /**
     * Get all project by status id and user id
     * @param status status id.
     * @param owner user id.
     * @param pageable Pageable object.
     * @return list of projects.
     */
    public Page<Project> getAllProjectsByStatusIdAndOwner(int status, int owner, Pageable pageable) {
        return projectRepository.findAllByStatusIdAndOwner(status, owner, pageable);
    }

    /**
     * Get all project by status id, dueDate greater than today date and user id.
     * @param status status id of the project.
     * @param date dude date of the project.
     * @param uid user id.
     * @param pageable Pageable object.
     * @return List of projects.
     */
    public Page<Project> findAllByStatusIdAndDueDateGreaterThanEqual(int status, Date date, int uid, Pageable pageable) {
        List<Integer> appliedProjectIds = assessmentStatusRepository.findAllProjectIdByUid(uid);
        return projectRepository.findAllByStatusIdAndDueDateGreaterThanEqualAndIdNotIn(status, date, appliedProjectIds, pageable);
    }

    /**
     * Get all projects by user id who had created the project.
     * @param ownerId user id.
     * @param pageable Pageable object.
     * @return list of projects belongs to the user id.
     */
    public Page<Project> getAllProjectsByOwner(int ownerId, Pageable pageable){
        return projectRepository.findAllByOwner(ownerId, pageable);
    }

    /**
     * Update the project status for given project id.
     * @param id project id.
     * @param status status id.
     */
    public void updateProjectStatus(int id, int status){
        projectRepository.updateProjectStatus(status, id);
    }

    /**
     * Get the project by given project id.
     * @param id project id.
     * @return project.
     */
    public List<Project> getAllProjectsByProjectID(int id) {

        return projectRepository.findAllByProjectID(id);
    }

    /**
     * update assessment id for the given project.
     * @param id project id.
     * @param assessmentId assessment id of the project.
     */
    public void updateProjectAssessmentId(int id, String assessmentId){
        projectRepository.updateProjectAssessmentId(assessmentId, id);
        updateProjectStatus(id, ProjectStatus.OPEN.value());
    }
}
