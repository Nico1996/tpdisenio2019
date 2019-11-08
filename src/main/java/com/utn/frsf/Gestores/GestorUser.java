package com.utn.frsf.Gestores;

import com.utn.frsf.DAO.UserDAO;
import com.utn.frsf.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorUser {

    @Autowired
    UserDAO userDAO;

    public List<User> findAll(){
        return userDAO.findAll();
    }

    public User findById(Long id){
        User user = userDAO.findById(id).get();
        return user;
    }

    public boolean existsUserByUsernameAndPassword(String username, String password){

        if(userDAO.findUserByUsernameAndPassword(username,password)==null){
            return false;
        }
        else return true;
    }

}
