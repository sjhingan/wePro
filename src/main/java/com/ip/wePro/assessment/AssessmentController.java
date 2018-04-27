package com.ip.wePro.assessment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {
	
	@Autowired
	AssessmentService assessmentService;
	
	/* This method will return the newly created assessmentID for the project which is creating this assessment*/
	@PostMapping("/add/{projectId}")	
	public String addAssessment(@RequestBody AssessmentList assessmentList,@PathVariable int projectId)
	{
		System.out.println("list="+assessmentList + "\nPID="+projectId);
		return assessmentService.addAssessment(assessmentList,projectId);		
	}
		
	/* This method will retrieve the list of all questions & their respective options of respective assessment*/
	@GetMapping("/get/{assessmentId}")
	public List<Assessment> getAssessment(@PathVariable String assessmentId)
	{		
		return assessmentService.getAssessment(assessmentId);
	}
	
	/*This method will edit the existing assessment*/
	@PutMapping("/update/{assessmentId}")
	public void updateAssessment(@RequestBody AssessmentList assessmentList)
	{
		assessmentService.updateAssessment(assessmentList);
	}
	
	/*This method will delete the assessment*/
	@DeleteMapping("/delete/{assessmentId}")
	public void deleteAssessment(@PathVariable String assessmentId)
	{
		assessmentService.deleteAssessment(assessmentId);
	}

}
