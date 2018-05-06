package com.ip.wePro.assessment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AssessmentResultRepository extends JpaRepository<AssessmentResult,ProjectAssessmentMappingForResultSubmission>{
	
	/**
     * This method will fire query to DB to delete all the records of assessment based on assessmentId.
     * @param assessmentId
     * @return
     */
	@Transactional
	void deleteByProjectAssessmentMappingForResultSubmissionAssessmentId(String assessmentId);

	/**
     * This method will fire query to DB to get all the records of assessment result based on assessmentId.
     * @param assessmentId
     * @return list of user & their grades
     */
	List<AssessmentResult> findByProjectAssessmentMappingForResultSubmissionAssessmentId(String assessmentId);
}
