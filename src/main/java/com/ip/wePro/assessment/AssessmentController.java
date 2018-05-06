package com.ip.wePro.assessment;

import java.util.List;

import com.ip.wePro.project.ProjectService;
import com.ip.wePro.project.ProjectStatus;
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

	@Autowired
	ProjectService projectService;
	
	/**
     * This method will save assessment created by manager into DB & generates unique assessment id 
     * which is stored in project table.
     * @param projectId
     * @param list of assessment objects
     * @return
     */
	@PostMapping("/add/{projectId}")	
	public void addAssessment(@RequestBody AssessmentList assessmentList,@PathVariable int projectId)
	{
		System.out.println("list="+assessmentList + "\nPID="+projectId);
		String assessmentId = assessmentService.addAssessment(assessmentList,projectId);
		projectService.updateProjectAssessmentId(projectId, assessmentId);
	}
	
	/**
     * This method will retrieve the list of all questions & their respective options for respective assessment
     * @param assessmentId
     * @return List of assessment objects
     */
	@GetMapping("/get/{assessmentId}")
	public List<Assessment> getAssessment(@PathVariable String assessmentId)
	{		
		return assessmentService.getAssessment(assessmentId);
	}
	
	/**
     * This method will edit the existing assessment if required
     * @param assessmentId
     * @param updated assessment in the form of list of questions
     * @return
     */
	@PutMapping("/update/{assessmentId}")
	public void updateAssessment(@RequestBody AssessmentList assessmentList)
	{
		assessmentService.updateAssessment(assessmentList);
	}
	
	/**
     * This method will delete the assessment if required
     * @param assessmentId
     * @return
     */	
	@DeleteMapping("/delete/{assessmentId}")
	public void deleteAssessment(@PathVariable String assessmentId)
	{
		assessmentService.deleteAssessment(assessmentId);
	}

}
