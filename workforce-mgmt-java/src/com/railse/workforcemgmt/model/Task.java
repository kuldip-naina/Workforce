package com.railse.workforcemgmt.model;

import java.time.LocalDate;

public class Task {
    private String id;
    private String title;
    private String staffId;
    private LocalDate startDate;
    private LocalDate dueDate;
    private Status status;
    private Priority priority;

    // Constructor 1: Status then Priority
    public Task(String id, String title, String staffId, LocalDate startDate, LocalDate dueDate, Status status, Priority priority) {
        this.id = id;
        this.title = title;
        this.staffId = staffId;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
    }

    // Constructor 2: Priority then Status (used in TaskService)
    public Task(String id, String title, String staffId, LocalDate startDate, LocalDate dueDate, Priority priority, Status status) {
        this.id = id;
        this.title = title;
        this.staffId = staffId;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getStaffId() { return staffId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getDueDate() { return dueDate; }
    public Status getStatus() { return status; }
    public Priority getPriority() { return priority; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setStaffId(String staffId) { this.staffId = staffId; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public void setStatus(Status status) { this.status = status; }
    public void setPriority(Priority priority) { this.priority = priority; }
}
