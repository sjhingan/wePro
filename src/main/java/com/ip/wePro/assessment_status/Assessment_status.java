package com.ip.wePro.assessment_status;

import com.ip.wePro.User.User;
import com.ip.wePro.project.Project;

import javax.persistence.*;


/**
 * Assessment_status class match the assessment_status table in the database.
 * The variables match the columns of the table.
 */
@Entity
public class Assessment_status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "assesment_status")
    private String assesmentStatus;

    public Assessment_status() {

    }

    /**
     * Assessment_status parameterize constructor.
     * @param user USer ID of which assessment is pending.
     * @param project Project ID of the user (Of which assessment is pending).
     * @param assesmentStatus Status of the assessment of the project.
     */
    public Assessment_status(User user, Project project, String assesmentStatus) {
        this.user = user;
        this.project = project;
        this.assesmentStatus = assesmentStatus;
    }

    /**
     * Get the id of the project.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the project.
     * @param id date to apply for the project.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the Applicant/user.
     * @return Owner id is returned.
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user of the project
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get the Project id of the user.
     * @return project id is returned.
     */
    public Project getProject() {
        return project;
    }

    /**
     * Set the project id to the project.
     * @param project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Get the assesmentStatus of the project.
     * @return assesmentStatus (pending or completed) is returned.
     */
    public String getAssesmentStatus() {
        return assesmentStatus;
    }

    /**
     * Set the assesmentStatus to the project.
     * @param assesmentStatus
     */
    public void setAssesmentStatus(String assesmentStatus) {
        this.assesmentStatus = assesmentStatus;
    }
}


