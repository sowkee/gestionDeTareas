package com.proyectos.gestionDeTareas.Repository;


import com.proyectos.gestionDeTareas.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
