package com.proyectos.gestionDeTareas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID_USER")
    private long idUser;
    @JsonIgnore
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_LASTNAME")
    private String userLastName;
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    @Column(name = "ID_TASK")
    private long idTask;
    @Column(name = "ID_EXPENSES")
    private long idExpenses;
    @OneToMany(mappedBy = "user")
    private List<Task> userTask;
    @OneToMany(mappedBy = "user")
    private List<Expenses> userExpenses;

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

    public long getIdTask() {
        return idTask;
    }

    public void setIdTask(long idTask) {
        this.idTask = idTask;
    }

    public long getIdExpenses() {
        return idExpenses;
    }

    public void setIdExpenses(long idExpenses) {
        this.idExpenses = idExpenses;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
