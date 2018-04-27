package com.ip.wePro.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Page<Project> getAllProjects(Pageable pageable){
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

    public List<Project> getAllProjectsByStatusIdAndOwner(int status, int owner, Pageable pageable) {
        return projectRepository.findAllByStatusIdAndOwner(status, owner, pageable);
    }

    public Page<Project> getAllProjectsByStatusId(int status,Pageable pageable) {
        return projectRepository.findAllByStatusId(status, pageable);
    }

    public Page<Project> getAllProjectsByOwner(int ownerId, Pageable pageable){
        return projectRepository.findAllByOwner(ownerId, pageable);
    }

    public void updateProjectStatus(int id, int status){
        projectRepository.updateProjectStatus(id, status);
    }
}
