package com.railse.workforcemgmt;

import com.railse.workforcemgmt.model.Task;
import com.railse.workforcemgmt.model.Priority;
import com.railse.workforcemgmt.model.Status;
import com.railse.workforcemgmt.controller.TaskController;
import com.railse.workforcemgmt.service.TaskService;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        TaskController taskController = new TaskController(taskService);

        // Create task 1
        Task task1 = new Task(
            "task1",
            "Design Database",
            "staff1",
            LocalDate.of(2025, 8, 1),
            LocalDate.of(2025, 8, 10),
            Status.ACTIVE,
            Priority.HIGH
        );
        taskController.createTask(task1);

        // Create task 2
        Task task2 = new Task(
            "task2",
            "Implement API",
            "staff2",
            LocalDate.of(2025, 8, 5),
            LocalDate.of(2025, 8, 12),
            Status.ACTIVE,
            Priority.MEDIUM
        );
        taskController.createTask(task2);

        // Reassign task 2 to staff1
        taskController.reassignTask("task2", "staff1");

        // Fetch and print tasks for staff1
        List<Task> staffTasks = taskController.getTasksByStaffId(
            "staff1",
            LocalDate.of(2025, 8, 1),
            LocalDate.of(2025, 8, 15)
        );

        for (Task t : staffTasks) {
            System.out.println("Task Title: " + t.getTitle());
            System.out.println("Assigned To: " + t.getStaffId());
            System.out.println("Due Date: " + t.getDueDate());
            System.out.println("Priority: " + t.getPriority());
            System.out.println("Status: " + t.getStatus());
            System.out.println();
        }
    }
}
