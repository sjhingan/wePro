package com.ip.wePro.userSkills;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ip.wePro.skills.Skills;

public interface UserSkillsRepository extends JpaRepository<UserSkills, Integer> {

	@Query("select t.user_id from UserSkills t where t.skill.id in :skills")
	List<Integer> findUsersWithSkills(@Param(value = "skills") List<Integer> skills);

	@Query("select t from UserSkills t where t.user_id = :uid")
	List<UserSkills> findAllByUserId(@Param(value = "uid") Integer uid);

	/*@Modifying
	@Query("UPDATE UserSkills t SET t.skill= :skills where t.user_id = :uid")
	void updateUserSkills(@Param(value = "skills") List<Skills> skills,@Param(value = "uid") Integer uid);

	@Modifying @Query("Update UserSkills t set t.removed = :d where t.user_id = :uid")
	void deleteAllSkillsByUserId(@Param(value = "uid") Integer uid, @Param(value = "d") Boolean d);*/

	
}
