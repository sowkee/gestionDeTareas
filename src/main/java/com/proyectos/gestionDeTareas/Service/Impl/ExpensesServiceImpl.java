package com.proyectos.gestionDeTareas.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectos.gestionDeTareas.DataAcces.Repository.IExpensesRepository;
import com.proyectos.gestionDeTareas.Entity.Expenses;
import com.proyectos.gestionDeTareas.Entity.Task;
import com.proyectos.gestionDeTareas.Entity.User;
import com.proyectos.gestionDeTareas.Presentation.DTO.ExpensesDTORequest;
import com.proyectos.gestionDeTareas.Presentation.DTO.ExpensesDTOResponse;
import com.proyectos.gestionDeTareas.Service.IExpensesService;
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
public class ExpensesServiceImpl implements IExpensesService {

    @Autowired
    IExpensesRepository iExpensesRepository;

    @Autowired
    ObjectMapper objectMapper;

    Logger logger = LoggerFactory.getLogger(ExpensesServiceImpl.class);

    @Override
    public ExpensesDTOResponse getExpenseById(long id) {
        Optional<Expenses> optionalExpenses = iExpensesRepository.findById(id);
        try {
            if (optionalExpenses.isPresent()) {
                Expenses expenses = optionalExpenses.get();
                return convertExpenseToResponseDTO(expenses);
            }
        }catch (Exception e) {
            logger.error("User not found", e);
        }

        return null;
    }

    @Override
    public List<ExpensesDTOResponse> getAllExpenses() {
        List<Expenses> expensesList = iExpensesRepository.findAll();

        return expensesList.stream()
                .map(expenses -> objectMapper.convertValue(expenses, ExpensesDTOResponse.class))
                        .collect(Collectors.toList());
    }

    @Override
    public ExpensesDTOResponse createNewExpense(ExpensesDTORequest expensesDTORequest) {
        Expenses expenses = objectMapper.convertValue(expensesDTORequest, Expenses.class);
        iExpensesRepository.save(expenses);
        return convertExpenseToResponseDTO(expenses);
    }

    @Override
    public ExpensesDTOResponse updateExpense(long id, ExpensesDTORequest expensesDTORequest) {
        Expenses expenses = iExpensesRepository.findById(id).orElseThrow(NoSuchElementException::new);
        BeanUtils.copyProperties(expensesDTORequest, expenses);

        return convertExpenseToResponseDTO(expenses);
    }

    @Override
    public String deleteTask(long id) {
        Optional<Expenses> expensesOptional = iExpensesRepository.findById(id);
        if (expensesOptional.isPresent()) {
            Expenses expenses = expensesOptional.get();
            iExpensesRepository.delete(expenses);
            return "ID: " + expenses.getIdExpenses() + " Eliminated";
        }
        return null;
    }

    @Override
    public ExpensesDTOResponse convertExpenseToResponseDTO(Expenses expenses) {
        return objectMapper.convertValue(expenses, ExpensesDTOResponse.class);
    }
}
