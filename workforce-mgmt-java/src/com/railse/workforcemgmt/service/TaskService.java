package com.railse.workforcemgmt.service;

import com.railse.workforcemgmt.model.Task;
import com.railse.workforcemgmt.model.Priority;
import com.railse.workforcemgmt.model.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public void createTask(Task task) {
        tasks.add(task);
    }

    // ✅ Bug Fix: Reassign task by canceling the old one and creating a new one
    public void reassignTask(String taskId, String newStaffId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                // Cancel old task
                task.setStatus(Status.CANCELLED);

                // Create new task with updated staff but same details
                String newTaskId = "task" + (tasks.size() + 1);
                Task newTask = new Task(
                        newTaskId,
                        task.getTitle(),
                        newStaffId,
                        task.getStartDate(),
                        task.getDueDate(),
                        task.getPriority(),
                        Status.ACTIVE
                );

                tasks.add(newTask);
                break;
            }
        }
    }

    // 🔍 Fetch tasks by staff ID within date range, excluding CANCELLED (Bug 2)
    public List<Task> getTasksByStaffId(String staffId, LocalDate from, LocalDate to) {
        return tasks.stream()
                .filter(task -> task.getStaffId().equals(staffId)
                        && !task.getStartDate().isBefore(from)
                        && !task.getDueDate().isAfter(to)
                        && task.getStatus() != Status.CANCELLED)
                .collect(Collectors.toList());
    }

    // 🔍 Fetch all tasks by priority
    public List<Task> getTasksByPriority(Priority priority) {
        return tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }

    // 🔧 Change priority of a task
    public void changePriority(String taskId, Priority newPriority) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setPriority(newPriority);
                break;
            }
        }
    }

    // ✅ Optional: View all tasks (for debug/testing/demo)
    public List<Task> getAllTasks() {
        return tasks;
    }
}
