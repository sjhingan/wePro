package com.ip.wePro.assessment;

import java.util.List;

/*
 * This class is created to get the details of the assessment created by the manager while setting up the project.
 * We will take data from GUI using object of this class & will save data into DB as a assessment for particular project.
 * This details will be fetched later so that developer will be able to take the assessment as an eligible candidate for this 
 * project.
 */
public class AssessmentList {
	
	private List<Assessment> assessmentQuestions;
	
	public AssessmentList()
	{
		
	}

	public AssessmentList(List<Assessment> assessmentQuestions) {
		super();
		this.assessmentQuestions = assessmentQuestions;
	}

	public List<Assessment> getAssessmentQuestions() {
		return assessmentQuestions;
	}

	public void setAssessmentQuestions(List<Assessment> assessmentQuestions) {
		this.assessmentQuestions = assessmentQuestions;
	}
}
