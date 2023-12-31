package com.proyectos.gestionDeTareas.Service.Impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectos.gestionDeTareas.DataAcces.Repository.ITaskRepository;
import com.proyectos.gestionDeTareas.DataAcces.Repository.IUserRepository;
import com.proyectos.gestionDeTareas.Entity.Task;
import com.proyectos.gestionDeTareas.Entity.User;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTORequest;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTOResponse;
import com.proyectos.gestionDeTareas.Presentation.DTO.UserDTOResponse;
import com.proyectos.gestionDeTareas.Service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    IUserRepository iUserRepository;

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
    public List<TaskDTOResponse> getAllTask() throws JsonProcessingException{

        List<Task> tasks = iTaskRepository.findAll();

        List<TaskDTOResponse> taskDTOResponses = tasks.stream()
                .map(task -> {
                    TaskDTOResponse taskDTOResponse = objectMapper.convertValue(task, TaskDTOResponse.class);
                    taskDTOResponse.setUser(objectMapper.convertValue(task.getUser(), UserDTOResponse.class));
                    return taskDTOResponse;
                })
                .collect(Collectors.toList());

        return taskDTOResponses;

    }

    @Override
    public TaskDTOResponse createNewTask(long id, TaskDTORequest taskDTORequest) throws ChangeSetPersister.NotFoundException {
        Task task = objectMapper.convertValue(taskDTORequest, Task.class);
        User user = iUserRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        task.setUser(user);
        iTaskRepository.save(task);
        System.out.println("@@@@@@@" + task.getUser().getIdUser());
        return convertTaskToResponseDTO(task);
    }

    @Override
    public TaskDTOResponse updateTask(long id, TaskDTORequest taskDTORequest) {
        Task task = iTaskRepository.findById(id).orElseThrow(NoSuchElementException::new);
        //BeanUtils.copyProperties(taskDTORequest, task);
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
