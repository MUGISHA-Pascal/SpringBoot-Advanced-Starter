package com.starter.backend.dtos;

import com.starter.backend.enums.ETaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String title;
    private String description;
    private ETaskStatus status;
    private String assignedTo;
    public TaskDto(String title, String description, ETaskStatus status){
        this.title = title;
        this.description = description;
        this.status = status;
    }
}
