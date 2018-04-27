package com.ip.wePro.assessment_status;

import com.ip.wePro.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessment_status")
public class Assessment_statusController {

    @Autowired
    Assessment_statusService assessmentStatusService;

  /*  @GetMapping("/get/all")
    public List<Assessment_status> getAllAssessmentStatus(){
        return Assessment_statusService.getAllAssessment_Status();
    }

    @GetMapping("/get/{uid}/{status}")
    public List<Assessment_status> getAllProjectsByOwner(@PathVariable int uid){
        return Assessment_statusService.getAllProjectsByOwner(uid);
    }*/


    @GetMapping("/get/all")
    public List<Assessment_status> getAllProjects(){
        return assessmentStatusService.getAllAssessment_Status();
    }

    @GetMapping("/get/{uid}")
    public List<Assessment_status> getAllProjectsByOwner(@PathVariable int uid){
        return assessmentStatusService.getAllProjectsByOwner(uid);
    }

   @GetMapping("/get/{uid}/{assesmentStatus}")
    public List<Assessment_status> getAllProjectsByOwnerStatus(@PathVariable int uid, @PathVariable String assesmentStatus){
        return assessmentStatusService.getAllProjectsByOwnerStatus(uid, assesmentStatus);
    }

    /*@GetMapping("/get/project/{uid}/{assesmentStatus}")
    public List<Project> getAllProjectDetailsBypid(@PathVariable int uid, @PathVariable String assesmentStatus){
        return assessmentStatusService.getAllProjectDetailsBypid(uid, assesmentStatus);
    }*/

    @GetMapping("/get/gvprojectdet/{uid}/{assesmentStatus}")
    public List<Integer> getAllProjectsnumberByOwnerStatus(@PathVariable int uid, @PathVariable String assesmentStatus){
        return assessmentStatusService.getAllProjectsnumberByOwnerStatus(uid, assesmentStatus);
    }

    @GetMapping("/get/gvprojectfulldetails/{uid}/{assesmentStatus}")
    public List<Project> getAllProjectDetailsBypid(@PathVariable int uid, @PathVariable String assesmentStatus){
        return assessmentStatusService.getAllProjectDetailsBypid(uid, assesmentStatus);
    }


}
