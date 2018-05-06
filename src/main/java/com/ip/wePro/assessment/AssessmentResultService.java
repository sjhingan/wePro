package com.ip.wePro.assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ip.wePro.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentResultService {
	
	@Autowired
	AssessmentResultRepository assessmentResultRepository;
	@Autowired
	AssessmentRepository assessmentRepository;

	/**
     * This method compares answer submitted by developer with correct answers given by manager. Accordingly,
     * it calculates grades for developer & stores the result in the DB.
     * @param userId
     * @param List of question & respective selected answer by the developer 
     * @return
     */
	public void addResult(AssessmentSubmission submittedAssessment , int userId) {
				
		Map<Integer,Integer> CorrectSolution = new HashMap<Integer,Integer>();
		Map<Integer,Integer> marksMap = new HashMap<Integer,Integer>();
		
		/*These variables are used to calculate weightage of the test & marks obatained by developer.
		 * This is used to calculate result of the user like (obtainedMarks/assessmentTotal)
		 */
		float assessmentTotal = 0,marksObtained=0;
		
		String assessmentId = submittedAssessment.getAssessmentId();
				
		List<QuestionAnswer> questionSubmittedAnswer = submittedAssessment.getSubmittedQA();
		
		//Getting all questionset from Database based on AssessmentId.
		List<Assessment> allRecords = assessmentRepository.findWholeAssessmentById(assessmentId);		
		
		for(int i=0;i<allRecords.size();i++)
		{			
			int key = allRecords.get(i).getQuestionId();
			int correctAns = allRecords.get(i).getCorrectAnswer();
			int marks = allRecords.get(i).getMarks();

			//Calculating the total of the assessment 
			assessmentTotal +=marks;
			
			/*Creating a map like questionid=>Respective_correctAnswer. 
			It will be used to check how many questions user solved correctly.*/
			CorrectSolution.put(key, correctAns);			
			
			/* Creating a map like questionid=>Respective_marks.
			It will be used to calculate marks obtained by developer based on no. of questions he has solved correctly.*/
			marksMap.put(key, marks);
		}		
		
		/*
		 * In this loop, We will be comparing developer's solution with correct solution.
		 * Accrodingly, we will calcute marks he has obatained in this assessment.
		 */
		for(int i=0;i<questionSubmittedAnswer.size();i++)
		{
			if(CorrectSolution.get(questionSubmittedAnswer.get(i).getQid()) == questionSubmittedAnswer.get(i).getSelectedSolution())
			{
				marksObtained += marksMap.get(questionSubmittedAnswer.get(i).getQid());
			}
		}
		
		float finalMarks = (marksObtained/assessmentTotal)*100;
		
		/*
		 * Now, Creating an object of AssessmentResult & will save the record in the DB.
		 * This record will serve as, assessment submitted by the user & we are  storing his result.
		 */

		AssessmentResult resultObject = new AssessmentResult(new ProjectAssessmentMappingForResultSubmission(new User(userId), assessmentId), finalMarks);
		
		assessmentResultRepository.save(resultObject);		
	}

	/**
     * This method retrieves the userId & their grades for the assessment from DB.
     * @param assessmentId 
     * @return List of developer & their grades for particular assessment
     */
	public List<AssessmentResult> getResults(String assessmentId) {
		
		List<AssessmentResult> allList =  assessmentResultRepository.findByProjectAssessmentMappingForResultSubmissionAssessmentId(assessmentId);
		Collections.sort(allList);
		return allList;
	}

	/**
     * This method deletes all the records related to assessment from DB.
     * @param assessmentId 
     * @return
     */
	public void deleteResults(String assessmentId) {	
		
		assessmentResultRepository.deleteByProjectAssessmentMappingForResultSubmissionAssessmentId(assessmentId);
	}

}
