package com.guillerecchini.Portfolio.service;

import com.guillerecchini.Portfolio.model.Project;
import com.guillerecchini.Portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public ArrayList<Object> newProject(Project project){
        projectRepository.save(project);
        return new ArrayList<>(Arrays.asList("Creado correcatmente", 200));
    }
    public Project getProject(Long id){
        return projectRepository.findById(id).orElse(null);
    }

    public ArrayList<Object> editProject(Project project){

        Optional<Project> projectOptional = projectRepository.findById(project.getId());

        if(projectOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            projectRepository.save(project);
            return new ArrayList<>(Arrays.asList("Editado correcatmente", 200));
        }

    }

    public ArrayList<Object> deleteProject(Long id){
        Optional<Project> projectOptional = projectRepository.findById(id);

        if(projectOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            projectRepository.deleteById(id);
            return new ArrayList<>(Arrays.asList("Eliminado correcatmente", 200));
        }
    }

}
