package com.proyectos.gestionDeTareas.Service;


import com.proyectos.gestionDeTareas.Entity.Task;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTORequest;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTOResponse;
import org.springframework.stereotype.Service;

@Service
public interface ITaskService {
    TaskDTOResponse getTaskById(long id);
    TaskDTOResponse getAllTask();
    TaskDTOResponse createNewTask(TaskDTORequest taskDTORequest);
    TaskDTOResponse updateTask(long id, TaskDTORequest taskDTORequest);
    String deleteTask(long id);
    TaskDTOResponse convertTaskToResponseDTO(Task task);
}
