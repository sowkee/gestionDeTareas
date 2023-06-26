package com.proyectos.gestionDeTareas.Presentation.Controller;

import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTORequest;
import com.proyectos.gestionDeTareas.Presentation.DTO.TaskDTOResponse;
import com.proyectos.gestionDeTareas.Service.IExpensesService;
import com.proyectos.gestionDeTareas.Service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("task")
public class TaskController {
    Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    ITaskService iTaskService;

    @GetMapping("get/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getTaskById (@PathVariable long id) {
        Map<String, Object> res = new HashMap<>();
        TaskDTOResponse response = iTaskService.getTaskById(id);;

        res.put("status", HttpStatus.OK);
        res.put("tasks", response);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("get/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllTasks () {
        Map<String, Object> res = new HashMap<>();
        try {
            List<TaskDTOResponse> response = iTaskService.getAllTask();;

            res.put("status", HttpStatus.OK);
            res.put("tasks", response);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch (Exception e) {
            logger.error("Error.", e);
        }
        res.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        res.put("message", "Error");
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("create/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createNewExpenses (@PathVariable("id") long id, @RequestBody TaskDTORequest taskDTORequest) throws ChangeSetPersister.NotFoundException {
        Map<String, Object> res = new HashMap<>();
        TaskDTOResponse response = iTaskService.createNewTask(id, taskDTORequest);
        if (response != null) {
            res.put("status", HttpStatus.CREATED);
            res.put("tasks", response);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        res.put("status", HttpStatus.BAD_REQUEST);
        res.put("Message", "Error.");
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("update/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateExpenses (@PathVariable long id, @RequestBody TaskDTORequest taskDTORequest) {
        Map<String, Object> res = new HashMap<>();
        TaskDTOResponse response = iTaskService.updateTask(id, taskDTORequest);
        res.put("status", HttpStatus.ACCEPTED);
        res.put("tasks", response);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteExpenses (@PathVariable long id) {
        Map<String, Object> res =new HashMap<>();
        String response = this.iTaskService.deleteTask(id);
        res.put("status", HttpStatus.OK);
        res.put("tasks", response);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}