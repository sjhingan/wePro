package com.ip.wePro.userSkills;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ip.wePro.skills.Skills;

public interface UserSkillsRepository extends JpaRepository<UserSkills, Integer> {

	@Query("select t.user_id from UserSkills t where t.skill.id in (:skills)")
	List<Integer> findUsersWithSkills(@Param(value = "skills") List<Integer> skills);

	
}
