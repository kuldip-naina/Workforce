package com.railse.workforcemgmt.controller;

import com.railse.workforcemgmt.model.Task;
import com.railse.workforcemgmt.model.Priority;
import com.railse.workforcemgmt.service.TaskService;

import java.time.LocalDate;
import java.util.List;

public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public void createTask(Task task) {
        taskService.createTask(task);
        System.out.println("✅ Task created: " + task.getTitle());
    }

    public void reassignTask(String taskId, String newStaffId) {
        taskService.reassignTask(taskId, newStaffId);
        System.out.println("🔄 Task reassigned to: " + newStaffId);
    }

    public void changePriority(String taskId, Priority newPriority) {
        taskService.changePriority(taskId, newPriority);
        System.out.println("⚡ Priority changed to: " + newPriority);
    }

    public List<Task> getTasksByStaffId(String staffId, LocalDate from, LocalDate to) {
        List<Task> result = taskService.getTasksByStaffId(staffId, from, to);
        System.out.println("📋 Fetched " + result.size() + " tasks for " + staffId);
        return result;
    }

    public List<Task> getTasksByPriority(Priority priority) {
        List<Task> result = taskService.getTasksByPriority(priority);
        System.out.println("📌 " + result.size() + " tasks with priority: " + priority);
        return result;
    }

    public Task getTaskDetails(String taskId) {
        return taskService.getTaskById(taskId);
    }

    public void addComment(String taskId, String commentText) {
        taskService.addComment(taskId, commentText);
        System.out.println("💬 Comment added to task " + taskId);
    }

    public void printTaskDetails(Task task) {
        if (task == null) {
            System.out.println("⚠️ Task not found");
            return;
        }

        System.out.println("📄 Task ID: " + task.getId());
        System.out.println("Title: " + task.getTitle());
        System.out.println("Assigned to: " + task.getStaffId());
        System.out.println("Start Date: " + task.getStartDate());
        System.out.println("Due Date: " + task.getDueDate());
        System.out.println("Priority: " + task.getPriority());
        System.out.println("Status: " + task.getStatus());

        System.out.println("📝 Activity Log:");
        for (String log : task.getActivityLog()) {
            System.out.println(" - " + log);
        }

        System.out.println("💭 Comments:");
        for (String c : task.getComments()) {
            System.out.println(" - " + c);
        }
    }
}
