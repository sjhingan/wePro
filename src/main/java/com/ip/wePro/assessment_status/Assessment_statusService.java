package com.ip.wePro.assessment_status;

import com.ip.wePro.project.Project;
import com.ip.wePro.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is a service class which acts as a intermediate between the controller and the repository.
 * Controller will call the method in the service class to get the information as per rest call.
 * The service will invoke the repository methods which will fetch from the database and return the result.
 */
@Service
public class Assessment_statusService {


    @Autowired
    Assessment_statusRepository assessmentStatusRepository;

    @Autowired
    ProjectRepository projectRepository;

    /**
     * Get all Assessment_status
     * @return list of Assessment_status
     */

    public List<Assessment_status> getAllAssessment_Status() {

        return assessmentStatusRepository.findAll();
    }

    /**
     * Get all Assessment_status by user id
     * @param uid user id.
     * @return list of Assessment_status.
     */
    public  List<Assessment_status> getAllProjectsByOwner(int uid) {

        return assessmentStatusRepository.findAllByStatusIdAndOwner(uid);

    }


    /**
     * Get all Assessment_status by user id and status
     * @param status status of the assessment.
     * @param uid user id.
     * @return list of Assessment_status.
     */
    public List<Assessment_status> getAllProjectsByOwnerStatus(int uid, String status) {

        return assessmentStatusRepository.findAllByStatusIdAndOwnerStatus(uid, status);
    }

    /**
     * Get all Project IDs by user id and status
     * @param assesmentStatus status of the assessment.
     * @param uid user id.
     * @return list of Project IDs.
     */
    public List<Integer> getAllProjectsnumberByOwnerStatus(int uid, String assesmentStatus) {

        return assessmentStatusRepository.findAllProjectIDByStatusIdAndOwnerStatus(uid, assesmentStatus);
    }

    /**
     * Get all Project details by user id and status, transfer will be given to Project Repository
     * @param assesmentStatus status of the assessment.
     * @param uid user id.
     * @return list of Project and its details.
     */
    public List<Project> getAllProjectDetailsBypid(int uid, String assesmentStatus){

        return projectRepository.findAllProjectDetailsBypid(assessmentStatusRepository.findAllProjectIDByStatusIdAndOwnerStatus(uid, assesmentStatus));
    }

    /**
     * Add new assessment_status
     * @param assessment_status Assessment_status object.
     */
    public void addAssessment(Assessment_status assessment_status) {
        assessmentStatusRepository.save(assessment_status);
    }

    /**
     * Get all Assessment_status details by Project ID
     * @param projectId Project id.
     * @return list of Assessment_status for the project
     */
    public List<Assessment_status> findAllByProjectId(int projectId) {
        return assessmentStatusRepository.findAllByProjectId(projectId);
    }

    /**
     * Update the Assessment_status for given uid id and assessment ID with the given status.
     * @param status status of the assessment.
     * @param assessmentId User id.
     * @param uid assessment id.
     */
    public void updateAssessmentStatus(String status, String assessmentId, int uid){
        assessmentStatusRepository.updateAssessmentStatus(status, Integer.parseInt(assessmentId.split("_")[1]), uid);
    }
}
