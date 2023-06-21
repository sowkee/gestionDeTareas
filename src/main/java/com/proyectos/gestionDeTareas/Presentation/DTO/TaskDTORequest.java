package com.proyectos.gestionDeTareas.Presentation.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import java.sql.Date;

@Component
public class TaskDTORequest {
    @JsonProperty("idTask")
    private long idTask;
    @JsonProperty("taskTitle")
    private String taskTitle;
    @JsonProperty("taskDescription")
    private String taskDescription;
    @JsonProperty("taskDate")
    private Date taskDate;

    public long getIdTask() {
        return idTask;
    }

    public void setIdTask(long idTask) {
        this.idTask = idTask;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }
}
