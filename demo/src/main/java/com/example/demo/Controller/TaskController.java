package com.example.demo.Controller;

import com.example.demo.Entity.Task;
import com.example.demo.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TaskApp/Task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    //Add Task To User
    @PostMapping("/addTask/{userId}")
    public Task addTask(
            @PathVariable Long userId,
            @Valid @RequestBody Task task) {
        return taskService.addTask(userId, task);
    }

    // Get task by Id
    @GetMapping("/getTask/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    // Get All Task
    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Get Task By user
    @GetMapping("/getTasksByUser/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }

    // Update task
    @PutMapping("/updateTask/{taskId}")
    public Task updateTask(
            @PathVariable Long taskId,
            @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }

    // Delete Task
    @DeleteMapping("/deleteTask/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return "Task deleted successfully";
    }
}
