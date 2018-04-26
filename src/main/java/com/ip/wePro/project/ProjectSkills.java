package com.ip.wePro.project;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "project_skills")
@IdClass(ProjectSkills.class)
public class ProjectSkills implements Serializable {

    @Id
    @Column(name = "project_id")
    private int projectId;
    @Id
    @Column(name = "skill_name")
    private String skillName;

    public ProjectSkills(){

    }

    public ProjectSkills(int projectId, String skillName) {
        this.projectId = projectId;
        this.skillName = skillName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
