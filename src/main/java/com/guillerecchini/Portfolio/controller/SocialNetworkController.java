package com.guillerecchini.Portfolio.controller;

import com.guillerecchini.Portfolio.model.SocialNetwork;
import com.guillerecchini.Portfolio.service.SocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SocialNetworkController {
    @Autowired
    SocialNetworkService socialNetworkService;

    @PostMapping(value = "/social-network")
    public String newSocialNetwork(@RequestBody SocialNetwork socialNetwork){
        socialNetworkService.newSocialNetwork(socialNetwork);
        return "Creado con éxito";
    }

    @GetMapping(value = "/social-network/{id}")
    public SocialNetwork getSocialNetwork(@PathVariable Long id){
        return socialNetworkService.getSocialNetwork(id);
    }

    @PostMapping(value = "/socialNetwork/edit")
    public ResponseEntity<Object> editSocialNetwork(@RequestBody SocialNetwork socialNetwork){
        ArrayList<Object> response = socialNetworkService.editSocialNetwork(socialNetwork);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }

    @DeleteMapping(value = "/socialNetwork/delete/{id}")
    public ResponseEntity<Object> deleteSocialNetwork(@PathVariable(name = "id") Long id){
        ArrayList<Object> response = socialNetworkService.deleteSocialNetwork(id);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }
}
