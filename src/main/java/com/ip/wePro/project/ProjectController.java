package com.ip.wePro.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/get/all")
    public Page<Project> getAllProjects(Pageable pageable){
        return projectService.getAllProjects(pageable);
    }

    @GetMapping("/get")
    public Page<Project> getAllProjectsByStatusId(@RequestParam(value = "status") String status,Pageable pageable){
        return projectService.getAllProjectsByStatusId(ProjectStatus.valueOf(status.toUpperCase()).value(), pageable);
    }

    @GetMapping("/get/{uid}/{status}")
    public List<Project> getAllProjectsByStatusIdAndOwner(@PathVariable int uid, @PathVariable String status, Pageable pageable){
        return projectService.getAllProjectsByStatusIdAndOwner(ProjectStatus.valueOf(status.toUpperCase()).value(), uid, pageable);
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
    public Page<Project> getAllProjectsByOwner(@PathVariable(name = "uid") int id, Pageable pageable){
        return projectService.getAllProjectsByOwner(id, pageable);
    }

    @PutMapping("/update/{id}/{status}")
    public void updateProjectStatus(@PathVariable int id, @PathVariable String status){
        projectService.updateProjectStatus(id, ProjectStatus.valueOf(status.toUpperCase()).value());
    }
}
