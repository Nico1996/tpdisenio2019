package com.utn.frsf.DAO;


import com.utn.frsf.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  UserDAO extends JpaRepository<User,Long> {

    //Consulta SQL
    @Query(value="SELECT * FROM usuario WHERE username = :username AND password = :pass", nativeQuery = true)
    User findClientByUsernameAndPassword(@Param("username") String name, @Param("pass") String pass);

}

