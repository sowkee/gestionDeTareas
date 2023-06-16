package com.proyectos.gestionDeTareas.Service.Impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectos.gestionDeTareas.DataAcces.Repository.ITaskRepository;
import com.proyectos.gestionDeTareas.DataAcces.Repository.IUserRepository;
import com.proyectos.gestionDeTareas.Entity.Task;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTORequest;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTOResponse;
import com.proyectos.gestionDeTareas.Service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    ITaskRepository iTaskRepository;

    @Autowired
    ObjectMapper objectMapper;

    Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Override
    public TaskDTOResponse getTaskById(long id) {
        Optional<Task> taskOptional = iTaskRepository.findById(id);
        try {
            if (taskOptional.isPresent()) {
                Task task = taskOptional.get();
                return convertTaskToResponseDTO(task);
            }
        }catch (Exception e) {
            logger.error("An error ocurred");
        }
        return null;
    }

    @Override
    public TaskDTOResponse getAllTask() {
        return null;
    }

    @Override
    public TaskDTOResponse createNewTask(TaskDTORequest taskDTORequest) {
        return null;
    }

    @Override
    public TaskDTOResponse updateTask(long id, TaskDTORequest taskDTORequest) {
        return null;
    }

    @Override
    public String deleteTask(long id) {
        return null;
    }

    @Override
    public TaskDTOResponse convertTaskToResponseDTO(Task task) {
        return null;
    }
}
