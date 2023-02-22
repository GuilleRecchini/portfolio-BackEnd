package com.guillerecchini.Portfolio.service;

import com.guillerecchini.Portfolio.model.User;
import com.guillerecchini.Portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public ArrayList<Object>  newUser(User user){
        userRepository.save(user);
        return new ArrayList<>(Arrays.asList("Creado correcatmente", 200));
    }

    public ArrayList<Object> editUser(User user){

        Optional<User> userOptional = userRepository.findById(user.getId());

        if(userOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            userRepository.save(user);
            return new ArrayList<>(Arrays.asList("Editado correcatmente", 200));
        }

    }

    public ArrayList<Object> deleteUser(Long id){
        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            userRepository.deleteById(id);
            return new ArrayList<>(Arrays.asList("Eliminado correcatmente", 200));
        }
    }
}
