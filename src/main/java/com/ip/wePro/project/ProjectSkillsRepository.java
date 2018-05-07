package com.ip.wePro.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * ProjectSkills Repository is the interface that will connect to database and
 * perform DML operations.
 */
public interface ProjectSkillsRepository extends JpaRepository<ProjectSkills, Integer> {

    /**
     * This will fetch all the skills for given project id.
     * @param projectId project id.
     * @return list of project skills.
     */
    @Query("select t from ProjectSkills t where t.project = :projectId")
    public List<ProjectSkills> findAllSkillsByProjectId(@Param(value = "projectId") int projectId);

}
