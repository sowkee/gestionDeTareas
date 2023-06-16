package com.proyectos.gestionDeTareas.Presentation.DTO;

import com.proyectos.gestionDeTareas.Entity.Expenses;
import com.proyectos.gestionDeTareas.Entity.Task;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Component
public class UserDTORequest {

    private long idUser;

    private String userName;

    private String userLastName;

    private String userPassword;

    private long idTask;

    private long idExpenses;

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
}
