package com.ip.wePro.assessment;

import java.util.List;
import java.util.Map;

/*This class is created to take the data from GUI once developer submits the test. So, from GUI, using this class
 * server will accept the assessmentId & all qids & respective selected answers by the developer. Based on this data, we are
 * calculating the result of that developer for this test & storing it into the table for future retrieval. 
 */
public class AssessmentSubmission {
	
	private String assessmentId;
	private List<QuestionAnswer> submittedQA;
	
	public AssessmentSubmission()
	{
		
	}

	public AssessmentSubmission(String assessmentId, List<QuestionAnswer> submittedQA) {
		super();
		this.assessmentId = assessmentId;
		this.submittedQA = submittedQA;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public List<QuestionAnswer> getSubmittedQA() {
		return submittedQA;
	}

	public void setSubmittedQA(List<QuestionAnswer> submittedQA) {
		this.submittedQA = submittedQA;
	}

	@Override
	public String toString() {
		return "AssessmentSubmission [assessmentId=" + assessmentId + ", submittedQA=" + submittedQA + "]";
	}
}

class QuestionAnswer
{
	private int qid;
	private int selectedSolution;
	
	public QuestionAnswer()
	{
		
	}
	
	public QuestionAnswer(int qid, int selectedSolution) {
		super();
		this.qid = qid;
		this.selectedSolution = selectedSolution;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getSelectedSolution() {
		return selectedSolution;
	}

	public void setSelectedSolution(int selectedSolution) {
		this.selectedSolution = selectedSolution;
	}

	@Override
	public String toString() {
		return "QuestionAnswer [qid=" + qid + ", selectedSolution=" + selectedSolution + "]";
	}	
}
