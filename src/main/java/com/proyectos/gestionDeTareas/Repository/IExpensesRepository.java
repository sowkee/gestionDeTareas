package com.proyectos.gestionDeTareas.Repository;

import com.proyectos.gestionDeTareas.Entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExpensesRepository extends JpaRepository<Expenses, Long> {
}
