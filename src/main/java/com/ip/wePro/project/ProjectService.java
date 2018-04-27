package com.ip.wePro.project;


import com.ip.wePro.assessment_status.Assessment_statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectSkillsRepository projectSkillsRepository;

    @Autowired
    Assessment_statusRepository assessmentStatusRepository;

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public void addProject(Project project) {
        project = projectRepository.save(project);
        int projectId = project.getId();
        List<ProjectSkills> projectSkillsList = new LinkedList<>();
        Iterator iterator = project.getSkills().iterator();
        while(iterator.hasNext()){
            projectSkillsList.add(new ProjectSkills(projectId, iterator.next().toString()));
        }
        projectSkillsRepository.saveAll(projectSkillsList);
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

    public List<Project> getAllProjectsByStatusIdAndOwner(int owner, int status) {
        return projectRepository.findAllByStatusIdAndOwner(owner, status);
    }

    public List<Project> getAllProjectsByStatusId(int status) {
        return projectRepository.findAllByStatusId(status);
    }


    public List<Project> getAllProjectsByProjectID(int id) {

        return projectRepository.findAllByProjectID(id);
    }




}
