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
    private Long user_id;
    
    @OneToOne
    @JoinColumn(name = "skill_id")
    private Skills skill;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
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
