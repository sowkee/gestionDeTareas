package com.proyectos.gestionDeTareas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID_USER")
    private long idUser;

    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_LASTNAME")
    private String userLastName;
    @Column(name = "USER_PASSWORD")
    private String userPassword;


    @OneToMany(cascade ={CascadeType.PERSIST}, mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Task> userTask;


    @OneToMany(cascade ={CascadeType.PERSIST}, mappedBy = "user")
    @JsonIgnoreProperties("user")
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


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
