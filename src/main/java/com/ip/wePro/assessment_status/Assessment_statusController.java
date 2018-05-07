package com.ip.wePro.assessment_status;

import com.ip.wePro.assessment.Assessment;
import com.ip.wePro.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Assessment_statusController is the server access point.
 * It is the host of the REST APIs to perform all the operations with respect to the project.
 */
@RestController
@RequestMapping("/assessment_status")
public class Assessment_statusController {

    @Autowired
    Assessment_statusService assessmentStatusService;

    /**
     * Get all the Assessment_status in the system using GET method.
     * Only admin user have access to this url.
     * @return return the projects what is requested.
     */
    @GetMapping("/get/all")
    public List<Assessment_status> getAllProjects(){
        return assessmentStatusService.getAllAssessment_Status();
    }

    /**
     * Get all the Assessment_status for perticular user
     * @param uid uid is the user id of the User
     * @param uid User id who is requesting for the details.
     * @return List of Assessment_status user can apply for.
     */
    @GetMapping("/get/{uid}")
    public List<Assessment_status> getAllProjectsByOwner(@PathVariable int uid){
        return assessmentStatusService.getAllProjectsByOwner(uid);
    }

    /**
     * Fetch all the assesmentStatus details based on user and assessment status (pending or complete)
     * @param uid User id of the project.
     * @param assesmentStatus Status of the assessment.
     * @return List of Assessment_status the user have based on status.
     */
   @GetMapping("/get/{uid}/{assesmentStatus}")
    public List<Assessment_status> getAllProjectsByOwnerStatus(@PathVariable int uid, @PathVariable String assesmentStatus){
        return assessmentStatusService.getAllProjectsByOwnerStatus(uid, assesmentStatus);
    }

    /**
     * Fetch all the projectIDs details based on user and assessment status (pending or complete)
     * @param uid User id of the project.
     * @param assesmentStatus Status of the assessment.
     * @return List of Project IDs the user have based on status.
     */
    @GetMapping("/get/gvprojectdet/{uid}/{assesmentStatus}")
    public List<Integer> getAllProjectsnumberByOwnerStatus(@PathVariable int uid, @PathVariable String assesmentStatus){
        return assessmentStatusService.getAllProjectsnumberByOwnerStatus(uid, assesmentStatus);
    }

    /**
     * Fetch all the Project details based on user and assessment status (pending or complete)
     * @param uid User id of the project.
     * @param assesmentStatus Status of the assessment.
     * @return List of Project Details the user have based on status.
     */
    @GetMapping("/get/gvprojectfulldetails/{uid}/{assesmentStatus}")
    public List<Project> getAllProjectDetailsBypid(@PathVariable int uid, @PathVariable String assesmentStatus){
        return assessmentStatusService.getAllProjectDetailsBypid(uid, assesmentStatus);
    }

    /**
     * Use POST method to all the Assessment_status.
     * Add Assessment_status staus when assessment is taken successfully.
     * @param assessment_status Assessment_status is newly created .
     */
    @PostMapping("/add")
    public void addAssessment(@RequestBody Assessment_status assessment_status){
        assessmentStatusService.addAssessment(assessment_status);
    }

    /**
     * Fetch the Assessment_status for perticular project
     * @param projectId Project id of the project.
     * @return List of Assessment_status Details for the project
     */
    @GetMapping("/get/applied/{projectId}")
    public List<Assessment_status> findAllByProjectId(@PathVariable int projectId){
        return assessmentStatusService.findAllByProjectId(projectId);
    }
}
