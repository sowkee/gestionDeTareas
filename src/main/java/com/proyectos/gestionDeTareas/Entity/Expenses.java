package com.proyectos.gestionDeTareas.Entity;

import javax.persistence.*;

@Entity
@Table(name = "EXPENSES")
public class Expenses {
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

}
