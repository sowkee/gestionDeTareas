package com.proyectos.gestionDeTareas.DataAcces.Repository;


import com.proyectos.gestionDeTareas.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("Select * from Users")
    User getUserWithRelation();
}
