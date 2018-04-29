package com.ip.wePro.project;

import com.ip.wePro.userProject.UserProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Page<Project> getAllProjects(Pageable pageable){
        return projectService.getAllProjects(pageable);
    }

    @GetMapping("/get/applying/{uid}")
    public Page<Project> getAllProjectsByStatusId(@RequestParam(value = "status") String status,@PathVariable int uid, Pageable pageable){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());
        Date today = new Date();
        try {
            today = dateFormat.parse(currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return projectService.findAllByStatusIdAndDueDateGreaterThanEqual(ProjectStatus.valueOf(status.toUpperCase()).value(), today, uid, pageable);
    }

    /**
     * Fetch all the project details mapped to the owner
     * @param uid
     * @param status
     * @return
     */
    @GetMapping("/get/{uid}/{status}")
    public Page<Project> getAllProjectsByStatusIdAndOwner(@PathVariable int uid, @PathVariable String status, Pageable pageable){
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

    @PostMapping("/userprojects/add")
    public void addUserToProject(@RequestBody UserProject userProject){
        userProjectService.addUserToProject(userProject);
    }

    @GetMapping("/userprojects/getusers/{projectId}")
    public List<UserProject> getAllByProjectId(@PathVariable int projectId){
        return userProjectService.findAllByProjectId(projectId);
    }
}
