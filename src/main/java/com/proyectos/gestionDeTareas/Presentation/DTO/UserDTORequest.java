package com.proyectos.gestionDeTareas.Presentation.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


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
