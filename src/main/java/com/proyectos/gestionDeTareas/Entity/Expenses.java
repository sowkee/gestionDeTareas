package com.proyectos.gestionDeTareas.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user_expenses")
public class Expenses {
    @Id
    @Column(name = "id_expenses")
    private long idExpenses;
    @Column(name = "user_amount")
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
