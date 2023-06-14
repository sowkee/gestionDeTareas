package com.proyectos.gestionDeTareas.DTO;

import org.springframework.stereotype.Component;
import java.sql.Date;

@Component
public class TaskDTORequest {
    private long id;
    private String taskTitle;
    private String taskDescription;
    private Date taskDate;
}
