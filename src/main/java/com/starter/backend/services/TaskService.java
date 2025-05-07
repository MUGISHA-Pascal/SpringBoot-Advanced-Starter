package com.starter.backend.services;

import com.starter.backend.dtos.TaskDto;
import com.starter.backend.models.Task;
import com.starter.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public Task addTask(TaskDto taskDto){
        Task task = new Task(taskDto.getTitle(), taskDto.getDescription(),taskDto.getStatus());
        return taskRepository.save(task);
    }
    public Task updateTask(TaskDto taskDto, UUID id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        return taskRepository.save(task);
    }
    public String deleteTask(UUID id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return "Task deleted";
        }else{
            return "Task not found";
        }
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
}
