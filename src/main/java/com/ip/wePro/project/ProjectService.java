package com.ip.wePro.project;


import com.ip.wePro.assessment_status.Assessment_statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectSkillsRepository projectSkillsRepository;

    @Autowired
    Assessment_statusRepository assessmentStatusRepository;

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
        projectRepository.updateProjectStatus(id, status);
    }

    public List<Project> getAllProjectsByProjectID(int id) {

        return projectRepository.findAllByProjectID(id);
    }

    public void updateProjectAssessmentId(int id, int assessmentId){
        projectRepository.updateProjectAssessmentId(id, assessmentId);
        updateProjectStatus(id, ProjectStatus.OPEN.value());
    }
}
