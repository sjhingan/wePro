package com.ip.wePro.project;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

/**
 * This POJO class references project_skills table in the database.
 * For each project there are many skills associated with it.
 * This table store all the skill id for each project id.
 * For each project skill pair there is an unique id which is a primary key.
 */
@Entity
@Table(name = "project_skills")
public class ProjectSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "skill_id")
    private int skillId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id",nullable = false)
    @JsonBackReference
    private Project project;

    /**
     * ProjectSkills default constructor
     */
    public ProjectSkills(){

    }

    /**
     * ProjectSkills parameter constructor
     * @param project project object
     * @param skillId skill id
     */
    public ProjectSkills(Project project, int skillId) {
        this.project = project;
        this.skillId = skillId;
    }

    /**
     * Get unique id.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique id.
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the project object.
     * @return project object.
     */
    public Project getProject() {
        return project;
    }

    /**
     * Set the project object.
     * @param project project object.
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Get the skill id.
     * @return skill id.
     */
    public int getSkillId() {
        return skillId;
    }

    /**
     * Set the skill id.
     * @param skillId skill id.
     */
    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}
