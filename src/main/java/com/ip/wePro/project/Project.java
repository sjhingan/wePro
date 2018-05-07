package com.ip.wePro.project;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Project class match the project table in the database.
 * The variables match the columns of the table.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "status_id")
    private int statusId;
    private int duration;

    @Column(name = "due_date")
    private Date dueDate;
    private int owner;
    @Column(name = "assessment_id")
    private String assessmentId;
    private int positions;
    private int pay;
    @Column(name = "assessment_required")
    private String assessmentRequired;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "project", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ProjectSkills> skills;

    /**
     * Project default constructor
     */
    public Project(){

    }

    /**
     * Project parameterize constructor.
     * @param name Assign the name of the project.
     * @param description Description contains brief explanation about the project.
     * @param statusId Status of the project.
     * @param duration How many days to complete the project.
     * @param dueDate Date represents the application deadline.
     * @param owner The person who created the project.
     * @param assessmentId Assessment created to that project.
     * @param positions Number of developer required for the project.
     * @param pay Payment for the work.
     * @param assessmentRequired Determine whether the project have some assessment or not.
     */
    public Project(String name, String description, int statusId, int duration, Date dueDate, int owner, String assessmentId, int positions, int pay, String assessmentRequired) {
        this.name = name;
        this.description = description;
        this.statusId = statusId;
        this.duration = duration;
        this.dueDate = dueDate;
        this.owner = owner;
        this.assessmentId = assessmentId;
        this.positions = positions;
        this.pay = pay;
        this.assessmentRequired = assessmentRequired;
    }

    /**
     * Get the dueDate of the project.
     * @return dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Set the dueDte of the project.
     * @param dueDate date to apply for the project.
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Get the owner of the project.
     * @return Owner id is returned.
     */
    public int getOwner() {
        return owner;
    }

    /**
     * Set the owner id of the project.
     * @param owner Owner id.
     */
    public void setOwner(int owner) {
        this.owner = owner;
    }

    /**
     * Get the assessment id of the project.
     * @return Assessment id that is assigned to it.
     */
    public String getAssessmentId() {
        return assessmentId;
    }

    /**
     * Set the assessment id to the project when assessment is created.
     * @param assessmentId
     */
    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    /**
     * Get the number of positions required for the project.
     * @return Number of developers.
     */
    public int getPositions() {
        return positions;
    }

    /**
     * Set the number of positions required for the project.
     * @param positions Number of positions.
     */
    public void setPositions(int positions) {
        this.positions = positions;
    }

    /**
     * Payment for each developers who work for this project.
     * @return Dollar's per hour,
     */
    public int getPay() {
        return pay;
    }

    /**
     * Set the payment for each developers.
     * @param pay Dollar's per hour.
     */
    public void setPay(int pay) {
        this.pay = pay;
    }

    /**
     * Get the project id.
     * @return Id of the project.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the project id.
     * @param id id of the project.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the project.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the project.
     * @param name project name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the project description.
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the project description.
     * @param description description about the project.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the status id of the project.
     * @return status id.
     */
    public int getStatusId() {
        return statusId;
    }

    /**
     * Set the status id of the project.
     * @param statusId
     */
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    /**
     * Get the project duration.
     * @return project duration.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Set the project duration.
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Get all mapped skills for the project.
     * @return list of skills
     */
    public Set<ProjectSkills> getSkills() {
        return skills;
    }

    /**
     * Set the skills required for the project.
     * @param skills list of skills.
     */
    public void setSkills(Set<ProjectSkills> skills) {
        this.skills = skills;
    }

    /**
     * Get whether the assessment is present or not.
     * @return assessment required or not.
     */
    public String getAssessmentRequired() {
        return assessmentRequired;
    }

    /**
     * Set the assessment required or not.
     * @param assessmentRequired assessment required or not.
     */
    public void setAssessmentRequired(String assessmentRequired) {
        this.assessmentRequired = assessmentRequired;
    }
}
