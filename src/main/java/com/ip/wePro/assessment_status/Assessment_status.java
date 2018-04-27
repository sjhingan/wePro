package com.ip.wePro.assessment_status;

import javax.persistence.*;

@Entity
public class Assessment_status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int uid;
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "assesment_status")
    private String assesmentStatus;

    public Assessment_status() {

    }


    public Assessment_status(int uid, int projectId, String assesmentStatus) {
        this.uid = uid;
        this.projectId = projectId;
        this.assesmentStatus = assesmentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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


