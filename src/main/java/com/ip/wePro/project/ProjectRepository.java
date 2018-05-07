package com.ip.wePro.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Project Reposition is the interface that will connect to database and
 * perform DML operations.
 */
public interface ProjectRepository extends JpaRepository<Project, Integer>, PagingAndSortingRepository<Project,Integer> {

    /**
     * Find all the project for given status id and owner
     * @param status status id.
     * @param owner owner id.
     * @param pageable pageable object to limit the result set.
     * @return list of project objects.
     */
//    @Query("select p from Project p where p.owner = :owner and p.statusId = :status")
    Page<Project> findAllByStatusIdAndOwner(@Param("status") int status, @Param("owner") int owner, Pageable pageable);

    /**
     * Find all project for given status id, dueDate greater than today date and
     * project id's which are already applied.
     * @param status status id of the project.
     * @param date due date of the project.
     * @param appliedProjectIds project id'd which are already applied by the user.
     * @param pageable Pageable object to limit the result set.
     * @return list of project objects.
     */
//    @Query("select p from Project p where p.statusId = :status")
    Page<Project> findAllByStatusIdAndDueDateGreaterThanEqualAndIdNotIn(@Param("status") int status, @Param("date") Date date, @Param("appliedProjectIds") List<Integer> appliedProjectIds,Pageable pageable);

    /**
     * Find all project by given user id.
     * @param owner user id who have created the project.
     * @param pageable Pageable object to limit the result set.
     * @return list of project objects.
     */
//    @Query("select p from Project p where p.owner = :owner")
    Page<Project> findAllByOwner(@Param("owner") int owner, Pageable pageable);

    /**
     * Update the project status for given project id.
     * @param status status that need to be updated.
     * @param id id of the project that needs to be updated.
     * @return number of projects that the status is updated.
     */
    @Transactional
    @Modifying
    @Query("update Project p set p.statusId = :status where p.id = :id")
    int updateProjectStatus(@Param("status") int status, @Param("id") int id);

    /**
     * Find all the project for given user id.
     * @param owner user id.
     * @return list of project for given user id.
     */
    @Query("select p from Project p where p.owner = :owner and p.statusId in (0,1,2,3)")
    List<Project> findAllByOwner(@Param("owner") int owner);

    /**
     * Find the project by project id.
     * @param id project id.
     * @return Project object matching the project id.
     */
    @Query("select p from Project p where p.id = :id")
    List<Project> findAllByProjectID(@Param("id") int id);

    /**
     * Find all project for given list of projects.
     * @param allProjectIDByStatusIdAndOwnerStatus list of project id's.
     * @return list of projects.
     */
    @Query("select p from Project p where p.id in :projectIdList")
    List<Project> findAllProjectDetailsBypid(@Param("projectIdList")List<Integer> allProjectIDByStatusIdAndOwnerStatus);

    /**
     * Update the assessment id for the given project id.
     * @param assessmentId Assessment id that is created for the project.
     * @param id project id to which the assessment need to be updated for.
     * @return number of projects the assessment id is updated for.
     */
    @Transactional
    @Modifying
    @Query("update Project p set p.assessmentId = :assessmentId where p.id = :id")
    int updateProjectAssessmentId(@Param("assessmentId") String assessmentId, @Param("id") int id);
}
