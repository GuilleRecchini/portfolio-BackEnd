package com.guillerecchini.Portfolio.controller;

import com.guillerecchini.Portfolio.model.WorkExperience;
import com.guillerecchini.Portfolio.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService workExperienceService;

    @PostMapping(value = "/work-experience")
    public String newWorkExperience(@RequestBody WorkExperience workExperience){
        workExperienceService.newWorkExperience(workExperience);
        return "Creado con éxito";
    }

    @GetMapping("/work-experience/{id}")
    public WorkExperience getWorkExperience(@PathVariable(name = "id") Long id){
        return workExperienceService.getWorkExperience(id);
    }

    @PostMapping(value = "/workExperience/edit")
    public ResponseEntity<Object> editWorkExperience(@RequestBody WorkExperience workExperience){
        ArrayList<Object> response = workExperienceService.editWorkExperience(workExperience);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }

    @DeleteMapping(value = "/workExperience/delete/{id}")
    public ResponseEntity<Object> deleteWorkExperience(@PathVariable(name = "id") Long id){
        ArrayList<Object> response = workExperienceService.deleteWorkExperience(id);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }



}
