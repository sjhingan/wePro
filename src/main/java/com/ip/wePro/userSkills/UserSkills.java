package com.ip.wePro.userSkills;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ip.wePro.skills.Skills;

@Entity
@Table(name="user_skills")
public class UserSkills {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    @Column(name = "user_id")
    private Integer user_id;
    
    @OneToOne
    @JoinColumn(name = "skill_id")
    private Skills skill;
    
    @Column(name="deleted")
    private Boolean removed;
    

	public Boolean getRemoved() {
		return removed;
	}

	public void setRemoved(Boolean removed) {
		this.removed = removed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Skills getSkill() {
		return skill;
	}

	public void setSkill(Skills skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "UserSkills [id=" + id + ", user_id=" + user_id + ", skill=" + skill + "]";
	}
}
