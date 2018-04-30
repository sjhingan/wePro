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

    public Page<Project> getAllProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    public void addProject(Project project) {
        if(project.getAssessmentRequired().equals("Yes")){
            project.setStatusId(ProjectStatus.SAVED.value());
        }else{
            project.setStatusId(ProjectStatus.OPEN.value());
        }
        projectRepository.save(project);

        try {
            notificationService.sendNotificationForProject(project);
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Error in sending notification for matching skills: ");
        }
    }

    public Project getProject(int id) {
        return projectRepository.findById(id).get();
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }

    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    public Page<Project> getAllProjectsByStatusIdAndOwner(int status, int owner, Pageable pageable) {
        return projectRepository.findAllByStatusIdAndOwner(status, owner, pageable);
    }

    public Page<Project> findAllByStatusIdAndDueDateGreaterThanEqual(int status, Date date, int uid, Pageable pageable) {
        List<Integer> appliedProjectIds = assessmentStatusRepository.findAllProjectIdByUid(uid);
        return projectRepository.findAllByStatusIdAndDueDateGreaterThanEqualAndIdNotIn(status, date, appliedProjectIds, pageable);
    }

    public Page<Project> getAllProjectsByOwner(int ownerId, Pageable pageable){
        return projectRepository.findAllByOwner(ownerId, pageable);
    }

    public void updateProjectStatus(int id, int status){
        projectRepository.updateProjectStatus(status, id);
    }

    public List<Project> getAllProjectsByProjectID(int id) {

        return projectRepository.findAllByProjectID(id);
    }

    public void updateProjectAssessmentId(int id, String assessmentId){
        projectRepository.updateProjectAssessmentId(assessmentId, id);
        updateProjectStatus(id, ProjectStatus.OPEN.value());
    }
}
