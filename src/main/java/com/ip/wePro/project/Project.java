package com.ip.wePro.project;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @Column(name = "status_id")
    private int statusId;
    private int duration;
    @Column(name = "due_date")
    private Date dueDate;
    private int owner;
    @Column(name = "assessment_id")
    private int assessmentId;
    private int positions;
    private int pay;
    @Column(name = "assessment_required")
    private String assessmentRequired;
    @Transient
    private Set<String> skills;

    public Project(){

    }

    public Project(String name, String description, int statusId, int duration, Date dueDate, int owner, int assessmentId, int positions, int pay, String assessmentRequired) {
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public int getPositions() {
        return positions;
    }

    public void setPositions(int positions) {
        this.positions = positions;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public String getAssessmentRequired() {
        return assessmentRequired;
    }

    public void setAssessmentRequired(String assessmentRequired) {
        this.assessmentRequired = assessmentRequired;
    }
}
