package com.guillerecchini.Portfolio.Controller;

import com.guillerecchini.Portfolio.Model.Project;
import com.guillerecchini.Portfolio.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping(value = "/project")
    public String newProject(@RequestBody Project project){
        projectService.newProject(project);
        return "Creado con éxito";
    }

    @GetMapping(value = "/project/{id}")
    public Project getProject(@PathVariable Long id){
        return projectService.getProject(id);
    }

    @PostMapping(value = "/project/edit")
    public ResponseEntity<Object> editProject(@RequestBody Project project){
        ArrayList<Object> response = projectService.editProject(project);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }

    @DeleteMapping(value = "/project/delete/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable(name = "id") Long id){
        ArrayList<Object> response = projectService.deleteProject(id);
        return new ResponseEntity<>(response.get(0), HttpStatusCode.valueOf((Integer)response.get(1)));
    }
}
