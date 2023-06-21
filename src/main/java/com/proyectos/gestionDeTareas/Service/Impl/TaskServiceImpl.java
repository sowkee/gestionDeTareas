package com.proyectos.gestionDeTareas.Service.Impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectos.gestionDeTareas.DataAcces.Repository.ITaskRepository;
import com.proyectos.gestionDeTareas.Entity.Task;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTORequest;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTOResponse;
import com.proyectos.gestionDeTareas.Service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<TaskDTOResponse> getAllTask() {
        List<Task> taskList = iTaskRepository.findAll();

        return taskList.stream()
                .map(task -> objectMapper.convertValue(task, TaskDTOResponse.class))
                .collect(Collectors.toList());


    }

    @Override
    public TaskDTOResponse createNewTask(TaskDTORequest taskDTORequest) {
        Task task = objectMapper.convertValue(taskDTORequest, Task.class);
        iTaskRepository.save(task);

        return convertTaskToResponseDTO(task);
    }

    @Override
    public TaskDTOResponse updateTask(long id, TaskDTORequest taskDTORequest) {
        Task task = iTaskRepository.findById(id).orElseThrow(NoSuchElementException::new);
        BeanUtils.copyProperties(taskDTORequest, task);
        iTaskRepository.save(task);

        return convertTaskToResponseDTO(task);
    }

    @Override
    public String deleteTask(long id) {
        Optional<Task> taskOptional = iTaskRepository.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            iTaskRepository.save(task);
            return "ID: " + task.getIdTask() + " Eliminated.";
        }
        return null;
    }

    @Override
    public TaskDTOResponse convertTaskToResponseDTO(Task task) {
        return objectMapper.convertValue(task, TaskDTOResponse.class);
    }
}
