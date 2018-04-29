package com.ip.wePro.assessment;

import com.ip.wePro.User.User;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class ProjectAssessmentMappingForResultSubmission implements Serializable{

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@NotNull
	private String assessmentId;
	
	public ProjectAssessmentMappingForResultSubmission()
	{
		
	}

	public ProjectAssessmentMappingForResultSubmission(@NotNull User user, @NotNull String assessmentId) {
		super();
		this.user = user;
		this.assessmentId = assessmentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}
}
