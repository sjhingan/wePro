package com.ip.wePro.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/get/all")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("/get")
    public List<Project> getAllProjectsByStatusId(@RequestParam(value = "status") String status){
        return projectService.getAllProjectsByStatusId(ProjectStatus.valueOf(status.toUpperCase()).value());
    }

    @GetMapping("/get/{uid}/{status}")
    public List<Project> getAllProjectsByStatusIdAndOwner(@PathVariable int uid, @PathVariable String status){
        return projectService.getAllProjectsByStatusIdAndOwner(uid, ProjectStatus.valueOf(status.toUpperCase()).value());
    }

    @PostMapping("/add")
    public void getAllProjects(@RequestBody Project project){
         projectService.addProject(project);

    }

    @GetMapping("/get/{id}")
    public Project getProjectById(@PathVariable int id){
        return projectService.getProject(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProjectById(@PathVariable int id){
        projectService.deleteProject(id);
    }

    @PutMapping("/update")
    public void updateProject(@RequestBody Project project){
        projectService.updateProject(project);
    }

    @GetMapping("/get/owner/{uid}")
    public List<Project> getAllProjectsByOwner(@PathVariable(name = "uid") int id){
        return projectService.getAllProjectsByOwner(id);
    }

    @PutMapping("/update/{id}/{status}")
    public void updateProjectStatus(@PathVariable int id, @PathVariable String status){
        projectService.updateProjectStatus(id, ProjectStatus.valueOf(status.toUpperCase()).value());
    }
}
