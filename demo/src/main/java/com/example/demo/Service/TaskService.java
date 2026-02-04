package com.example.demo.Service;

import com.example.demo.Entity.Task;
import com.example.demo.Entity.User;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;


    public Task addTask(Long userId, Task task) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        task.setUser(user);
        return taskRepository.save(task);
    }


    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByUserUserId(userId);
    }


    public Task updateTask(Long taskId, Task task) {
        Task existing = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setStatus(task.getStatus());

        return taskRepository.save(existing);
    }


    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
