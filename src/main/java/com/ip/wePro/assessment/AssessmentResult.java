package com.ip.wePro.assessment;

//import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="assessment_result")
public class AssessmentResult implements Comparable<AssessmentResult>{
	
	@EmbeddedId
	private ProjectAssessmentMappingForResultSubmission projectAssessmentMappingForResultSubmission;
	
	private float result;
	
	public AssessmentResult()
	{
		
	}

	public AssessmentResult(ProjectAssessmentMappingForResultSubmission projectAssessmentMappingForResultSubmission,
			float result) {
		super();
		this.projectAssessmentMappingForResultSubmission = projectAssessmentMappingForResultSubmission;
		this.result = result;
	}

	public ProjectAssessmentMappingForResultSubmission getProjectAssessmentMappingForResultSubmission() {
		return projectAssessmentMappingForResultSubmission;
	}

	public void setProjectAssessmentMappingForResultSubmission(
			ProjectAssessmentMappingForResultSubmission projectAssessmentMappingForResultSubmission) {
		this.projectAssessmentMappingForResultSubmission = projectAssessmentMappingForResultSubmission;
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "AssessmentResult [projectAssessmentMappingForResultSubmission="
				+ projectAssessmentMappingForResultSubmission + ", result=" + result + "]";
	}

	@Override
	public int compareTo(AssessmentResult o) {
		// TODO Auto-generated method stub
		return (int) (o.getResult()-this.getResult());
	}
}
