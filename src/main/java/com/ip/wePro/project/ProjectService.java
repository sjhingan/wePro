package com.ip.wePro.project;


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

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public void addProject(Project project) {
        if(project.getAssessmentRequired().equals("Yes")){
            project.setStatusId(ProjectStatus.SAVED.value());
        }else{
            project.setStatusId(ProjectStatus.OPEN.value());
        }
        project = projectRepository.save(project);
        int projectId = project.getId();
        System.out.println(projectId);
        List<ProjectSkills> projectSkillsList = new LinkedList<>();
        if(project.getSkills() != null && project.getSkills().size() > 0){
            Iterator iterator = project.getSkills().iterator();
            while(iterator.hasNext()){
                projectSkillsList.add(new ProjectSkills(projectId, iterator.next().toString()));
            }
            projectSkillsRepository.saveAll(projectSkillsList);
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

    public List<Project> getAllProjectsByStatusIdAndOwner(int owner, int status) {
        return projectRepository.findAllByStatusIdAndOwner(owner, status);
    }

    public List<Project> getAllProjectsByStatusId(int status) {
        return projectRepository.findAllByStatusId(status);
    }

    public List<Project> getAllProjectsByOwner(int ownerId){
        return projectRepository.findAllByOwner(ownerId);
    }

    public void updateProjectStatus(int id, int status){
        projectRepository.updateProjectStatus(id, status);
    }
}
