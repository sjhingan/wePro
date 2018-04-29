
package com.ip.wePro.assessment;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ProjectAssessmentMappingForResultSubmission implements Serializable{
	
	@NotNull
	private int userId;
	
	@NotNull
	private String assessmentId;
	
	public ProjectAssessmentMappingForResultSubmission()
	{
		
	}

	public ProjectAssessmentMappingForResultSubmission(@NotNull int userId, @NotNull String assessmentId) {
		super();
		this.userId = userId;
		this.assessmentId = assessmentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}
}
