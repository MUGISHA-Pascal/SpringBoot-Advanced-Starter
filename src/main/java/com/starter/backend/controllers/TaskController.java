package com.starter.backend.controllers;

import com.starter.backend.dtos.TaskDto;
import com.starter.backend.models.Task;
import com.starter.backend.services.TaskService;
import graphql.GraphQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
    @QueryMapping
    public List<Task> getAllTasks(GraphQLContext context){
        String authorization = context.get("Authorization");
        System.out.println("token "+authorization);
        return taskService.getAllTasks();
    }
    @MutationMapping
    public Task addTask(@Argument("input") TaskDto task){
         try{
             return taskService.addTask(task);}catch (Exception e){
            System.out.println("-----"+e.getMessage()+"-----");
         }
         return null;
    }
    @MutationMapping
    public Task updateTask(@Argument("input") TaskDto task, @Argument("id")UUID id){
        return taskService.updateTask(task,id);
    }
    @MutationMapping
    public String deleteTask(@Argument("id") UUID id){
        return taskService.deleteTask(id);
    }
}
