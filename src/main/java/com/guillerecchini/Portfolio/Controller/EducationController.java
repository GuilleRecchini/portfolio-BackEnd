package com.guillerecchini.Portfolio.Controller;

import com.guillerecchini.Portfolio.Model.Education;
import com.guillerecchini.Portfolio.Service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EducationController {

    @Autowired
    EducationService educationService;

    @PostMapping(value = "/education")
    public String newEducation(@RequestBody Education education){
        educationService.newEducation(education);
        return "Creado con éxito";
    }

    @GetMapping("/education/{id}")
    public Education getEducation(@PathVariable(name = "id") Long id){
        return educationService.getEducation(id);
    }

    @PostMapping(value = "/education/edit")
    public ResponseEntity<Object> editEducation(@RequestBody Education education){
        ArrayList<Object> response = educationService.editEducation(education);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }

    @DeleteMapping(value = "/education/delete/{id}")
    public ResponseEntity<Object> deleteEducation(@PathVariable(name = "id") Long id){
        ArrayList<Object> response = educationService.deleteEducation(id);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }

}
