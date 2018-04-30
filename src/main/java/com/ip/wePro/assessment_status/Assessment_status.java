package com.ip.wePro.assessment_status;

import com.ip.wePro.User.User;
import com.ip.wePro.project.Project;

import javax.persistence.*;

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


    public Assessment_status(User user, Project project, String assesmentStatus) {
        this.user = user;
        this.project = project;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getAssesmentStatus() {
        return assesmentStatus;
    }

    public void setAssesmentStatus(String assesmentStatus) {
        this.assesmentStatus = assesmentStatus;
    }
}


