package com.proyectos.gestionDeTareas.Presentation.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectos.gestionDeTareas.Entity.Expenses;
import com.proyectos.gestionDeTareas.Entity.Task;
import org.springframework.stereotype.Component;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;


@Component
public class UserDTORequest {
    @JsonProperty("idUser")
    private long idUser;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userLastName")
    private String userLastName;
    @JsonProperty("userPassword")
    private String userPassword;
    @JsonProperty("tasks")
    private List<Task> tasks;
    @JsonProperty("expenses")
    private List<Expenses> expenses;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Expenses> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expenses> expenses) {
        this.expenses = expenses;
    }
}
