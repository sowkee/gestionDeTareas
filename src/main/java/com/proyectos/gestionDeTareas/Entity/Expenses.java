package com.proyectos.gestionDeTareas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "EXPENSES")
@JsonIgnoreProperties("user")
public class Expenses implements Serializable {
    @Id
    @Column(name = "ID_EXPENSES")
    private long idExpenses;
    @Column(name = "AMOUNT")
    private int monto;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
