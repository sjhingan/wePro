package com.ip.wePro.assessment;

import java.util.List;
import java.util.Map;

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
	
	/* This method will get the assessment submitted by developer. Then it will calculate the result for individual.
	 * Then userId,assessmentId,Result will be saved to assessmentResult table. */
	@PostMapping("/add/{userId}")
	public void addResult(@RequestBody AssessmentSubmission submittedAssessment,@PathVariable String userId)
	{
		assessmentResultService.addResult(submittedAssessment,userId);		
	}
	
	/* This method will return the list of all developers with their results based on the assessmentId */
	@GetMapping("/get/{assessmentId}")
	public List<AssessmentResult> getResults(@PathVariable String assessmentId)
	{
		return assessmentResultService.getResults(assessmentId);		
	}
	
	/* This method will delete all the records of assessment based on assessmentId. */
	@DeleteMapping("/delete/{assessmentId}")
	public void deleteResults(@PathVariable String assessmentId)
	{
		assessmentResultService.deleteResults(assessmentId);
	}
}
