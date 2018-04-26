package com.ip.wePro.assessment;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ProjectAssessmentMappingForResultSubmission implements Serializable{
	
	@NotNull
	private String userId;
	
	@NotNull
	private String assessmentId;
	
	public ProjectAssessmentMappingForResultSubmission()
	{
		
	}

	public ProjectAssessmentMappingForResultSubmission(@NotNull String userId, @NotNull String assessmentId) {
		super();
		this.userId = userId;
		this.assessmentId = assessmentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}
}
