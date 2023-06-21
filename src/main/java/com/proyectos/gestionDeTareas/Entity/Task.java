package com.proyectos.gestionDeTareas.Entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @Column(name = "ID_TASK")
    private long idTask;
    @Column(name = "TITLE")
    private String taskTitle;
    @Column(name = "DESCRIPTION")
    private String taskDescription;
    @CreationTimestamp
    @Column(name = "TASK_DATE")
    private Date taskDate;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;

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
