package com.guillerecchini.Portfolio.Controller;

import com.guillerecchini.Portfolio.Model.Skill;
import com.guillerecchini.Portfolio.Service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SkillController {

    @Autowired
    SkillService skillService;

    @PostMapping(value = "/skill")
    public String newSkill(@RequestBody Skill skill){
        skillService.newSkill(skill);
        return "Creado con éxito";
    }

    @GetMapping(value = "/skill/{id}")
    public Skill getSkill(@PathVariable Long id){
        return skillService.getSkill(id);
    }

    @PostMapping(value = "/skill/edit")
    public ResponseEntity<Object> editSkill(@RequestBody Skill skill){
        ArrayList<Object> response = skillService.editSkill(skill);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }

    @DeleteMapping(value = "/skill/delete/{id}")
    public ResponseEntity<Object> deleteSkill(@PathVariable(name = "id") Long id){
        ArrayList<Object> response = skillService.deleteSkill(id);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }

}
