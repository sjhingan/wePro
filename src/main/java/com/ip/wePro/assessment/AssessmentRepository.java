package com.ip.wePro.assessment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AssessmentRepository extends JpaRepository<Assessment,Integer> {

	@Query("Select A from Assessment A where A.assessmentId = :assessmentId")
	List<Assessment> findWholeAssessmentById(@Param("assessmentId") String assessmentId);
	
	@Transactional
	@Modifying
	@Query("Delete from Assessment where assessmentId = :assessmentId")
	void deleteWholeAssessmentById(@Param("assessmentId") String assessmentId);
}
