package com.guillerecchini.Portfolio.controller;

import com.guillerecchini.Portfolio.model.User;
import com.guillerecchini.Portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="/users/{id}")
    public User getUser(@PathVariable(name="id") Long id){
        return userService.getUser(id);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<Object> newUser(@RequestBody User user){
        ArrayList<Object> response = userService.newUser(user);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }

    @PostMapping(value = "/user/edit")
    public ResponseEntity<Object> editUser(@RequestBody User user){
        ArrayList<Object> response = userService.editUser(user);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(name = "id") Long id){
        ArrayList<Object> response = userService.deleteUser(id);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }

}
