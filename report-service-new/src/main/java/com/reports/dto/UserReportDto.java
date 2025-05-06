package com.reports.dto;

public class UserReportDto {
    private Long id;
    private String userFName;
    private String emailId;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserFName() { return userFName; }
    public void setUserFName(String userFName) { this.userFName = userFName; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }
}
