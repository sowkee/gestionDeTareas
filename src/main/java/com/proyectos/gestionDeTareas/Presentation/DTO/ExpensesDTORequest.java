package com.proyectos.gestionDeTareas.Presentation.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectos.gestionDeTareas.Entity.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ExpensesDTORequest {

    @JsonProperty("idExpenses")
    private long idExpenses;
    @JsonProperty("monto")
    private int monto;

    @JsonProperty("user")
    private User user;

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
