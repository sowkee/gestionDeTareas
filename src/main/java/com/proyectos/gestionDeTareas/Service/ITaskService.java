package com.proyectos.gestionDeTareas.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.proyectos.gestionDeTareas.Entity.Task;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTORequest;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTOResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public interface    ITaskService {
    TaskDTOResponse getTaskById(long id);
    List<TaskDTOResponse> getAllTask() throws JsonProcessingException, InvocationTargetException, IllegalAccessException;
    TaskDTOResponse createNewTask(long id, TaskDTORequest taskDTORequest) throws ChangeSetPersister.NotFoundException;
    TaskDTOResponse updateTask(long id, TaskDTORequest taskDTORequest);
    String deleteTask(long id);
    TaskDTOResponse convertTaskToResponseDTO(Task task);
}
