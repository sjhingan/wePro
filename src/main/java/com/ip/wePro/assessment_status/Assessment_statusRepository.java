package com.ip.wePro.assessment_status;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface Assessment_statusRepository extends JpaRepository<Assessment_status, Integer> {

    @Query("select p from Assessment_status p where p.user.id = :uid")
    List<Assessment_status> findAllByStatusIdAndOwner(@Param("uid") int uid);

    @Query("select p from Assessment_status p where p.user.id = :uid and p.assesmentStatus = :assesmentStatus")
    List<Assessment_status> findAllByStatusIdAndOwnerStatus(@Param("uid") int uid, @Param("assesmentStatus") String assesmentStatus);

    @Query("select p.project from Assessment_status p where p.user.id = :uid and p.assesmentStatus = :assesmentStatus")
    List<Integer> findAllProjectIDByStatusIdAndOwnerStatus(@Param("uid") int uid, @Param("assesmentStatus") String assesmentStatus);

    @Query("select p.project.id from Assessment_status p where p.user.id = :uid")
    List<Integer> findAllProjectIdByUid(@Param("uid") int uid);

    List<Assessment_status> findAllByProjectId(int projectId);

    @Transactional
    @Modifying
    @Query(value = "update Assessment_status p set p.assesment_status = :status where p.project_id = :projectId and p.user_id = :uid", nativeQuery = true)
    int updateAssessmentStatus(@Param("status") String status, @Param("projectId") int projectId, @Param("uid") int uid);
}
