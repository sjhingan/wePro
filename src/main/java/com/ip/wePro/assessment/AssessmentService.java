package com.ip.wePro.assessment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AssessmentService {
	
	@Autowired
	AssessmentRepository assessmentRepository;
	
	//Add assessment in the database & return respective assessmentId
	public String addAssessment(AssessmentList assessmentList,int projectId)
	{		
		String assessmentId = "Assessment_"+projectId;
		
		List<Assessment> allQuestions = assessmentList.getAssessmentQuestions();
		int length = allQuestions.size();
		
		// Setting up the customized id for each question
		for(int i=0;i<length;i++)
		{
			allQuestions.get(i).setAssessmentId(assessmentId);		
		}
		
		assessmentRepository.saveAll(allQuestions);		
		
		return assessmentId;
	}
	
	// Get the assessment based on the assessmentId.
	public List<Assessment> getAssessment(String assessmentId)
	{			
		List<Assessment> allQuestions = assessmentRepository.findWholeAssessmentById(assessmentId);
		
		//Changing the correct_solution & marks value to garbage. So that user will not get the correct solution values. 
		for(int i=0;i<allQuestions.size();i++)
		{
			allQuestions.get(i).setCorrectAnswer(-1);
			allQuestions.get(i).setMarks(0);
		}		
		return allQuestions;
	}
	
	//If manager wants to edit the existing assessment
	public void updateAssessment(AssessmentList assessmentList)
	{
		List<Assessment> allQuestions = assessmentList.getAssessmentQuestions();
		assessmentRepository.saveAll(allQuestions);
	}
		
	public void deleteAssessment(String assessmentId)
	{
		assessmentRepository.deleteWholeAssessmentById(assessmentId);
	}
}
