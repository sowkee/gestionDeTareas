package com.proyectos.gestionDeTareas.Presentation.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;


@Component
public class UserDTOResponse extends UserDTORequest{
    @JsonIgnore
    private String userPassword;
}
