package com.ip.wePro.assessment_status;

import com.ip.wePro.User.User;

import javax.persistence.*;

@Entity
public class Assessment_status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "assesment_status")
    private String assesmentStatus;

    public Assessment_status() {

    }


    public Assessment_status(User user, int projectId, String assesmentStatus) {
        this.user = user;
        this.projectId = projectId;
        this.assesmentStatus = assesmentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getAssesmentStatus() {
        return assesmentStatus;
    }

    public void setAssesmentStatus(String assesmentStatus) {
        this.assesmentStatus = assesmentStatus;
    }
}


