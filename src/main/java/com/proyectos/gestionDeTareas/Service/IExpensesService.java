package com.proyectos.gestionDeTareas.Service;

import com.proyectos.gestionDeTareas.Entity.Expenses;
import com.proyectos.gestionDeTareas.Entity.Task;
import com.proyectos.gestionDeTareas.Presentation.DTO.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExpensesService {
    ExpensesDTOResponse getExpenseById(long id);
    List<ExpensesDTOResponse> getAllExpenses();
    ExpensesDTOResponse createNewExpense(ExpensesDTORequest expensesDTORequest);
    ExpensesDTOResponse updateExpense (long id, ExpensesDTORequest expensesDTORequest);
    String deleteTask(long id);

    ExpensesDTOResponse convertExpenseToResponseDTO(Expenses expenses);
}
