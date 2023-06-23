package com.proyectos.gestionDeTareas.Presentation.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectos.gestionDeTareas.Entity.User;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.util.List;

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
    @JsonProperty("user")
    private UserDTOResponse user;

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

    public UserDTOResponse getUser() {
        return user;
    }

    public void setUser(UserDTOResponse user) {
        this.user = user;
    }
}
