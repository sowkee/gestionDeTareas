package com.proyectos.gestionDeTareas.Presentation.Controller;


import com.proyectos.gestionDeTareas.Presentation.DTO.ExpensesDTORequest;
import com.proyectos.gestionDeTareas.Presentation.DTO.ExpensesDTOResponse;
import com.proyectos.gestionDeTareas.Service.IExpensesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("expenses")
public class ExpensesController {

    Logger logger = LoggerFactory.getLogger(ExpensesController.class);

    @Autowired
    IExpensesService iExpensesService;

    @GetMapping("get/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getExpensesById (@PathVariable long id) {
        Map<String, Object> res = new HashMap<>();
        ExpensesDTOResponse response = this.iExpensesService.getExpenseById(id);
        res.put("status", HttpStatus.OK);
        res.put("expenses", response);

        return  new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("get/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllExpenses () {
        Map<String, Object> res = new HashMap<>();
        List<ExpensesDTOResponse> listResponseDto = this.iExpensesService.getAllExpenses();
        res.put("status", HttpStatus.OK);
        res.put("expenses", listResponseDto);
        return  new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createNewExpense (@RequestBody ExpensesDTORequest expensesDTORequest) {
        Map<String, Object> res = new HashMap<>();
        ExpensesDTOResponse response = this.iExpensesService.createNewExpense(expensesDTORequest);
        res.put("status", HttpStatus.CREATED);
        res.put("expenses", response);

        return  new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateExpense (@PathVariable long id, @RequestBody ExpensesDTORequest expensesDTORequest) {
        Map<String, Object> res = new HashMap<>();
        ExpensesDTOResponse response = this.iExpensesService.updateExpense(id, expensesDTORequest);
        res.put("status", HttpStatus.OK);
        res.put("expenses", response);
        return  new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteExpenses (@PathVariable long id) {
        Map<String, Object> res = new HashMap<>();
        String response = this.iExpensesService.deleteTask(id);
        res.put("status", HttpStatus.OK);
        res.put("expenses", response);
        return  new ResponseEntity<>(res, HttpStatus.OK);
    }

}
