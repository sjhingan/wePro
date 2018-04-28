package com.ip.wePro.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("select p from Project p where p.owner = :owner and p.statusId = :status")
    List<Project> findAllByStatusIdAndOwner(@Param("owner") int owner, @Param("status") int status);

    @Query("select p from Project p where p.statusId = :status")
    List<Project> findAllByStatusId(@Param("status") int status);

    @Query("select p from Project p where p.owner = :owner")
    List<Project> findAllByOwner(@Param("owner") int owner);
}
