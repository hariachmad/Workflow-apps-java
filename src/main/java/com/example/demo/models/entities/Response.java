package com.example.demo.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="response")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "DateTime is required")
    @FutureOrPresent(message = "DateTime Must now or Present")
    private LocalDate dateTimeResponse;

    private String notes;

    private String attachmentUrl;

    private String responseStatus;

    public Response(
            @NotNull(message = "DateTime is required") @FutureOrPresent(message = "DateTime Must now or Present") LocalDate dateTimeResponse,
            String notes, String attachmentUrl, String responseStatus) {
        this.dateTimeResponse = dateTimeResponse;
        this.notes = notes;
        this.attachmentUrl = attachmentUrl;
        this.responseStatus = responseStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateTimeResponse() {
        return dateTimeResponse;
    }

    public void setDateTimeResponse(LocalDate dateTimeResponse) {
        this.dateTimeResponse = dateTimeResponse;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    

    


}
