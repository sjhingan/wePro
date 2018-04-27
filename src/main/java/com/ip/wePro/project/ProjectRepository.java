package com.ip.wePro.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer>, PagingAndSortingRepository<Project,Integer> {

//    @Query("select p from Project p where p.owner = :owner and p.statusId = :status")
    List<Project> findAllByStatusIdAndOwner(@Param("status") int status, @Param("owner") int owner, Pageable pageable);

//    @Query("select p from Project p where p.statusId = :status")
    Page<Project> findAllByStatusId(@Param("status") int status, Pageable pageable);

    @Query("select p from Project p where p.owner = :owner and p.statusId in (0,1,2,3)")
    Page<Project> findAllByOwner(@Param("owner") int owner, Pageable pageable);

    @Query("update Project p set p.statusId = :status where p.id = :id")
    Project updateProjectStatus(@Param("status") int status, @Param("id") int id);
}
