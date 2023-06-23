package com.proyectos.gestionDeTareas.Service.Impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectos.gestionDeTareas.DataAcces.Repository.ITaskRepository;
import com.proyectos.gestionDeTareas.DataAcces.Repository.IUserRepository;
import com.proyectos.gestionDeTareas.Entity.Task;
import com.proyectos.gestionDeTareas.Entity.User;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTORequest;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTOResponse;
import com.proyectos.gestionDeTareas.Presentation.DTO.UserDTOResponse;
import com.proyectos.gestionDeTareas.Service.ITaskService;
import com.proyectos.gestionDeTareas.Service.IUserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<TaskDTOResponse> getAllTask() throws JsonProcessingException {

        List<Task> tasks = iTaskRepository.findAll();
        List<TaskDTOResponse> taskDTOResponses = new ArrayList<>();

        for (Task task : tasks) {
            TaskDTOResponse taskDTOResponse = new TaskDTOResponse();

            taskDTOResponse.setIdTask(task.getIdTask());
            taskDTOResponse.setTaskTitle(task.getTaskTitle());
            taskDTOResponse.setTaskDescription(task.getTaskDescription());
            taskDTOResponse.setTaskDate(task.getTaskDate());

            UserDTOResponse userDTOResponse = new UserDTOResponse();
            User user = iUserRepository.findById(task.getUser().getIdUser()).orElse(null);
            if (user != null) {
                userDTOResponse.setIdUser(user.getIdUser());
                userDTOResponse.setUserName(user.getUserName());
                userDTOResponse.setUserLastName(user.getUserLastName());
                taskDTOResponse.setUser(userDTOResponse);
            }

            taskDTOResponses.add(taskDTOResponse);
        }

        return taskDTOResponses;

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
