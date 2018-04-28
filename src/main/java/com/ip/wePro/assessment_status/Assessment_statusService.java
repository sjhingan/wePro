package com.ip.wePro.assessment_status;

import com.ip.wePro.project.Project;
import com.ip.wePro.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Assessment_statusService {


    @Autowired
    Assessment_statusRepository assessmentStatusRepository;

    @Autowired
    ProjectRepository projectRepository;


    public List<Assessment_status> getAllAssessment_Status() {

        return assessmentStatusRepository.findAll();
    }

    public  List<Assessment_status> getAllProjectsByOwner(int uid) {

        return assessmentStatusRepository.findAllByStatusIdAndOwner(uid);

    }

    public List<Assessment_status> getAllProjectsByOwnerStatus(int uid, String status) {

        return assessmentStatusRepository.findAllByStatusIdAndOwnerStatus(uid, status);
    }

    public List<Integer> getAllProjectsnumberByOwnerStatus(int uid, String assesmentStatus) {

        return assessmentStatusRepository.findAllProjectIDByStatusIdAndOwnerStatus(uid, assesmentStatus);
    }


    public List<Project> getAllProjectDetailsBypid(int uid, String assesmentStatus){

        return projectRepository.findAllProjectDetailsBypid(assessmentStatusRepository.findAllProjectIDByStatusIdAndOwnerStatus(uid, assesmentStatus));
    }

}
