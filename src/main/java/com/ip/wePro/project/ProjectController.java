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

/**
 * ProjectController is the server access point.
 * It is the host of the REST APIs to perform all the operations with respect to the project.
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    
    @Autowired
    UserProjectService userProjectService;

    /**
     * Get all the projects in the system using GET method.
     * Only admin user have access to this url.
     * @param pageable Determines the number of project need to be sent back.
     * @return return the projects whats request for with page details.
     */
    @GetMapping("/get/all")
    public Page<Project> getAllProjects(Pageable pageable){
        return projectService.getAllProjects(pageable);
    }

    /**
     * Get all the project whose dueDate is greater than today, project status is as given
     * and not applied by that developer.
     * @param status Status id of the project
     * @param uid User id who is requesting for the details.
     * @param pageable Page size and number of elements in each page.
     * @return List of project user can apply for.
     */
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
     * @param uid User id of the project.
     * @param status Status of the project.
     * @return List of project the user have applied for.
     */
    @GetMapping("/get/{uid}/{status}")
    public Page<Project> getAllProjectsByStatusIdAndOwner(@PathVariable int uid, @PathVariable String status, Pageable pageable){
        return projectService.getAllProjectsByStatusIdAndOwner(ProjectStatus.valueOf(status.toUpperCase()).value(), uid, pageable);
    }

    /**
     * Use POST method to all the project.
     * Add project when new project is created.
     * @param project Project object that is newly created.
     */
    @PostMapping("/add")
    public void getAllProjects(@RequestBody Project project){
         projectService.addProject(project);
    }

    /**
     * Get project using project id.
     * @param id project that is required.
     * @return Project object.
     */
    @GetMapping("/get/{id}")
    public Project getProjectById(@PathVariable int id){
        return projectService.getProject(id);
    }

    /**
     * DELETE method to delete the project by project id.
     * @param id project id that need to be deleted.
     */
    @DeleteMapping("/delete/{id}")
    public void deleteProjectById(@PathVariable int id){
        projectService.deleteProject(id);
    }

    /**
     * Use PUT method to update the information.
     * Update the project information.
     * @param project project object with updated information.
     */
    @PutMapping("/update")
    public void updateProject(@RequestBody Project project){
        projectService.updateProject(project);
    }

    /**
     * Get all the project that is associated by user id.
     * @param id user id.
     * @param pageable Pageable object.
     * @return List of project objects.
     */
    @GetMapping("/get/owner/{uid}")
    public Page<Project> getAllProjectsByOwner(@PathVariable(name = "uid") int id, Pageable pageable){
        return projectService.getAllProjectsByOwner(id, pageable);
    }

    /**
     * Update the project status.
     * @param id Id of the project for which the status need to be update.
     * @param status status of the project to which it needs to be updated.
     */
    @PutMapping("/update/{id}/{status}")
    public void updateProjectStatus(@PathVariable int id, @PathVariable String status){
        projectService.updateProjectStatus(id, ProjectStatus.valueOf(status.toUpperCase()).value());
    }

    /**
     * Get all the project by project id.
     * @param id project id.
     * @return
     */
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

    /**
     * Assign project to user when the user is hired.
     * @param userProject Object contains user and project information.
     */
    @PostMapping("/userprojects/add")
    public void addUserToProject(@RequestBody UserProject userProject){
        userProjectService.addUserToProject(userProject);
    }

    /**
     * Get all the users who are assigned to the given project.
     * @param projectId project id.
     * @return List of UserProject objects who are working for the project,
     */
    @GetMapping("/userprojects/getusers/{projectId}")
    public List<UserProject> getAllByProjectId(@PathVariable int projectId){
        return userProjectService.findAllByProjectId(projectId);
    }
}
