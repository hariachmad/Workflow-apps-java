package com.example.demo.models.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="complaint")
public class Complaint implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title is required")
    private String title;

    private String Description;

    @NotEmpty(message = "Location is required")
    private String Location;

    private Integer ApprovalId;

    private Date ReportedDate;

    @NotEmpty(message = "Attachment Url is required")
    private String AttachmentUrl;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    public Complaint() {
    }

    public Complaint(String title, String description, String location, Date reportedDate, String attachmentUrl) {
        this.title = title;
        Description = description;
        Location = location;
        ReportedDate = reportedDate;
        AttachmentUrl = attachmentUrl;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public void setDescription(String description) {
        Description = description;
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

    public void setCategory(Category category) {
        this.category = category;
    }   
    
    public Category getCategory() {
        return this.category;
    }
}