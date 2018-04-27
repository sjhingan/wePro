package com.ip.wePro.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ip.wePro.userProject.UserProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    
    @Autowired
    UserProjectService userProjectService;

    @GetMapping("/get/all")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("/get")
    public List<Project> getAllProjectsByStatusId(@RequestParam(value = "status") String status){
        return projectService.getAllProjectsByStatusId(ProjectStatus.valueOf(status.toUpperCase()).value());
    }

    /**
     * Fetch all the project details mapped to the owner
     * @param uid
     * @param status
     * @return
     */
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

    @GetMapping("/get/{uid}")
    public List<Project> getAllProjectsByOwner(@PathVariable int uid, @PathVariable String status){
        return projectService.getAllProjectsByStatusIdAndOwner(uid, ProjectStatus.valueOf(status.toUpperCase()).value());
    }

    @GetMapping("/get/byprojectid/{id}")
    public List<Project> getAllProjectsByProjectID(@PathVariable int id){
        return projectService.getAllProjectsByProjectID(id);
    }

    
    /**
     * Fetch all the project details mapped to the user working on it.
     * @param uid
     * @param status
     * @return
     */
    @GetMapping("/userprojects/{uid}")
    public List<Project> getOpenProjectsOfUser(@PathVariable Long uid){
        return userProjectService.getOpenProjectsOfUser(uid);
    }
    
    /**
     * Fetch all the closed projects for a user
     * @param userId
     * @return
     */
    @GetMapping("/userprojects/history/{uid}")
    public List<Project> getClosedProjectsByUserId(@PathVariable Long uid){
        return userProjectService.getClosedProjectsByUserId(uid);
    }
}
