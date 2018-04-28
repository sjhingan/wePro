package com.ip.wePro.userProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserProjectRepository extends JpaRepository<UserProject, Integer> {

	/**
	 * Finding only active projects on which user is currently working
	 * @param userId
	 * @return
	 */
    @Query("select t from UserProject t where t.user_id = :userId and t.active=1")
    public List<UserProject> findOpenProjectsByUserId(@Param(value = "userId") Long userId);

    /**
     * Get all the projects that are closed for a user
     * @param userId
     * @return
     */
    @Query("select t from UserProject t where t.user_id = :userId and t.active=0")
	public List<UserProject> findClosedProjectsByUserId(@Param(value = "userId") Long userId);
}
