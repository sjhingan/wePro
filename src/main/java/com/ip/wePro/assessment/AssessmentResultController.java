package com.ip.wePro.assessment;

import java.util.List;
import java.util.Map;

import com.ip.wePro.assessment_status.Assessment_status;
import com.ip.wePro.assessment_status.Assessment_statusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assessment/result")
public class AssessmentResultController {
	
	@Autowired
	AssessmentResultService assessmentResultService;

	@Autowired
	Assessment_statusService assessment_statusService;
	
	/**
     * This method will get the assessment submitted by developer. Then it will calculate the result for individual.
     * Then userId,assessmentId,Result will be saved to assessmentResult table.
     * @param userId
     * @param list of question & their respective selected answer by developer
     * @return
     */
	@PostMapping("/add/{userId}")
	public void addResult(@RequestBody AssessmentSubmission submittedAssessment,@PathVariable int userId)
	{
		assessmentResultService.addResult(submittedAssessment,userId);
		assessment_statusService.updateAssessmentStatus("Completed", submittedAssessment.getAssessmentId(), userId);
	}
	
	/**
     * This method will return the list of all developers with their results based on the assessmentId
     * @param assessmentId
     * @return List of assessmentResult object which contains user & their grades for particular assessment
     */
	@GetMapping("/get/{assessmentId}")
	public List<AssessmentResult> getResults(@PathVariable String assessmentId)
	{
		return assessmentResultService.getResults(assessmentId);		
	}
	
	/**
     * This method will delete all the records of assessment based on assessmentId.
     * @param assessmentId
     * @return
     */
	@DeleteMapping("/delete/{assessmentId}")
	public void deleteResults(@PathVariable String assessmentId)
	{
		assessmentResultService.deleteResults(assessmentId);
	}
}
