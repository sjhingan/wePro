package com.ip.wePro.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer>, PagingAndSortingRepository<Project,Integer> {

//    @Query("select p from Project p where p.owner = :owner and p.statusId = :status")
    Page<Project> findAllByStatusIdAndOwner(@Param("status") int status, @Param("owner") int owner, Pageable pageable);

//    @Query("select p from Project p where p.statusId = :status")
    Page<Project> findAllByStatusIdAndDueDateGreaterThanEqualAndIdNotIn(@Param("status") int status, Date date, List<Integer> appliedProjectIds,Pageable pageable);

    @Query("select p from Project p where p.owner = :owner and p.statusId in (0,1,2,3)")
    Page<Project> findAllByOwner(@Param("owner") int owner, Pageable pageable);

    @Query("update Project p set p.statusId = :status where p.id = :id")
    Project updateProjectStatus(@Param("status") int status, @Param("id") int id);

    @Query("select p from Project p where p.owner = :owner and p.statusId in (0,1,2,3)")
    List<Project> findAllByOwner(@Param("owner") int owner);

    @Query("select p from Project p where p.id = :id")
    List<Project> findAllByProjectID(@Param("id") int id);

    @Query("select p from Project p where p.id in :projectIdList")
    List<Project> findAllProjectDetailsBypid(@Param("projectIdList")List<Integer> allProjectIDByStatusIdAndOwnerStatus);

    @Query("update Project p set p.assessmentId = :assessmentId where p.id = :id")
    Project updateProjectAssessmentId(@Param("assessmentId") int assessmentId, @Param("id") int id);
}
