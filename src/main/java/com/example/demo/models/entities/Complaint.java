package com.example.demo.models.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="complaint")
public class Complaint implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String Description;

    private String Category;

    private String Location;

    private Integer ApprovalId;

    private Date ReportedDate;

    private String AttachmentUrl;

    public Complaint() {
    }

    public Complaint(String title, String description, String category, String location, Date reportedDate,
            String attachmentUrl) {
        this.title = title;
        Description = description;
        Category = category;
        Location = location;
        ReportedDate = reportedDate;
        AttachmentUrl = attachmentUrl;
    }

    

    public void setTitle(String title) {
        this.title = title;
    }



    public void setDescription(String description) {
        Description = description;
    }



    public void setCategory(String category) {
        Category = category;
    }



    public void setLocation(String location) {
        Location = location;
    }



    public void setApprovalId(Integer approvalId) {
        ApprovalId = approvalId;
    }



    public void setAttachmentUrl(String attachmentUrl) {
        AttachmentUrl = attachmentUrl;
    }



    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return Description;
    }

    public String getCategory() {
        return Category;
    }

    public String getLocation() {
        return Location;
    }

    public Integer getApprovalId() {
        return ApprovalId;
    }

    public Date getReportedDate() {
        return ReportedDate;
    }

    public String getAttachmentUrl() {
        return AttachmentUrl;
    }   
}