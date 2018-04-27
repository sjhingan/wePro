package com.ip.wePro.assessment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AssessmentResultRepository extends JpaRepository<AssessmentResult,ProjectAssessmentMappingForResultSubmission>{
	
	@Transactional
	void deleteByProjectAssessmentMappingForResultSubmissionAssessmentId(String assessmentId);

	List<AssessmentResult> findByProjectAssessmentMappingForResultSubmissionAssessmentId(String assessmentId);
}
