package com.recipes.manager.controllers;


import com.recipes.manager.entities.User;
import com.recipes.manager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

@RestController
@RequestMapping(value ="/api/v1/users" )
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticateUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
        User u=service.authenticateUser(username,password);
        if(u!=null){
            System.out.println("User Found");
            return ResponseEntity.status(HttpStatus.OK).body(u);
        }
        return null;
    }
    @PostMapping("/signUp")
    public User addUser(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "fatherName") String fatherName,
            @RequestParam(name = "age") String age,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password) {
        User user=new User();
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        user.setFather_name(fatherName);
        user.setAge(Integer.valueOf(age));
        user.setUsername(email);
        user.setPassword(password);
        user.setActive(true);
        user=service.addNewUser(user);
        if(user!=null){
            return user;
        }
        return null;
    }

    private static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}
