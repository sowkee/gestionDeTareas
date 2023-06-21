package com.proyectos.gestionDeTareas.Presentation.DTO;

import org.springframework.stereotype.Component;



@Component
public class ExpensesDTORequest {

    private long idExpenses;
    private int monto;

    public long getIdExpenses() {
        return idExpenses;
    }

    public void setIdExpenses(long idExpenses) {
        this.idExpenses = idExpenses;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
