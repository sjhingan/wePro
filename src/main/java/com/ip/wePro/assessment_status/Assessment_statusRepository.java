package com.ip.wePro.assessment_status;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Assessment_status Reposition is the interface that will connect to database and
 * perform DML operations.
 */

@Repository
public interface Assessment_statusRepository extends JpaRepository<Assessment_status, Integer> {

    /**
     * Find all the Assessment_status for given User
     * @param uid user id.
     * @return list of assessment status for the user.
     */
    @Query("select p from Assessment_status p where p.user.id = :uid")
    List<Assessment_status> findAllByStatusIdAndOwner(@Param("uid") int uid);

    /**
     * Find all the Assessment_status for given User and assesmentStatus
     * @param uid user id.
     * @param assesmentStatus status of the assessment
     * @return list of assessment status for the user and status.
     */
    @Query("select p from Assessment_status p where p.user.id = :uid and p.assesmentStatus = :assesmentStatus")
    List<Assessment_status> findAllByStatusIdAndOwnerStatus(@Param("uid") int uid, @Param("assesmentStatus") String assesmentStatus);

    /**
     * Find all the Project IDs for given User and assesmentStatus
     * @param uid user id.
     * @param assesmentStatus status of the assessment
     * @return list of Project Ids for the user and status.
     */
    @Query("select p.project from Assessment_status p where p.user.id = :uid and p.assesmentStatus = :assesmentStatus")
    List<Integer> findAllProjectIDByStatusIdAndOwnerStatus(@Param("uid") int uid, @Param("assesmentStatus") String assesmentStatus);

    /**
     * Find all the Project IDs for given User
     * @param uid user id.
     * @return list of Project Ids for the user
     */
    @Query("select p.project.id from Assessment_status p where p.user.id = :uid")
    List<Integer> findAllProjectIdByUid(@Param("uid") int uid);

    /**
     * Find all the Assessment_status by project ID
     * @param projectId Project id.
     * @return list of assessment status of the Project.
     */
    List<Assessment_status> findAllByProjectId(int projectId);


    /**
     * Update the assessment status for the given project id and user id.
     * @param projectId Project id of the project
     * @param uid User ID of the User
     * @return number of Assessment_status the assessment status is updated for.
     */
    @Transactional
    @Modifying
    @Query(value = "update Assessment_status p set p.assesment_status = :status where p.project_id = :projectId and p.user_id = :uid", nativeQuery = true)
    int updateAssessmentStatus(@Param("status") String status, @Param("projectId") int projectId, @Param("uid") int uid);
}
