package com.ip.wePro.assessment_status;


import com.ip.wePro.project.Project;
import com.ip.wePro.project.ProjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Assessment_statusRepository extends JpaRepository<Assessment_status, Integer> {

    @Query("select p from Assessment_status p where p.uid = :uid")
    List<Assessment_status> findAllByStatusIdAndOwner(@Param("uid") int uid);

    @Query("select p from Assessment_status p where p.uid = :uid and p.assesmentStatus = :assesmentStatus")
    List<Assessment_status> findAllByStatusIdAndOwnerStatus(@Param("uid") int uid, @Param("assesmentStatus") String assesmentStatus);

    //@Query("select p from project p where p.pid in (select ass.project_id from Assessment_status as ass where ass.uid = :uid and ass.assesmentStatus = :assesmentStatus) ")
    //List<Project> findAllProjectDetailsBypid(@Param("uid") int uid, @Param("assesmentStatus") String assesmentStatus);

   // @Query("select p from project p where p.pid in (select ass.project_id from Assessment_status as ass where ass.uid = :uid and ass.assesmentStatus = :assesmentStatus) ")
    //List<Project> findAllProjectDetailsBypid(@Param("uid") int uid, @Param("assesmentStatus") String assesmentStatus);

    @Query("select p.projectId from Assessment_status p where p.uid = :uid and p.assesmentStatus = :assesmentStatus")
    List<Integer> findAllProjectIDByStatusIdAndOwnerStatus(@Param("uid") int uid, @Param("assesmentStatus") String assesmentStatus);






    

  /*  @Query("select p from Project p where p.statusId = :status")
    List<Project> findAllByStatusId(@Param("status") int status);

    @Query("select p from Project p where p.owner = :owner")
    List<Project> findAllByOwner(@Param("owner") int owner);*/
}
