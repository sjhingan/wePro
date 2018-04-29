package com.ip.wePro.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectSkillsRepository extends JpaRepository<ProjectSkills, Integer> {

    @Query("select t from ProjectSkills t where t.project = :projectId")
    public List<ProjectSkills> findAllSkillsByProjectId(@Param(value = "projectId") int projectId);

}
