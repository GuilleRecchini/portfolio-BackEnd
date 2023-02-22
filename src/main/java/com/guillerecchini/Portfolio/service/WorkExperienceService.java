package com.guillerecchini.Portfolio.service;

import com.guillerecchini.Portfolio.model.WorkExperience;
import com.guillerecchini.Portfolio.repository.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class WorkExperienceService {

    @Autowired
    WorkExperienceRepository workExperienceRepository;

    public WorkExperience getWorkExperience(Long id){
        return workExperienceRepository.findById(id).orElse(null);
    }

    public ArrayList<Object> newWorkExperience(WorkExperience workExperience){
        workExperienceRepository.save(workExperience);
        return new ArrayList<>(Arrays.asList("Creado correcatmente", 200));
    }

    public ArrayList<Object> editWorkExperience(WorkExperience workExperience){

        Optional<WorkExperience> workExperienceOptional = workExperienceRepository.findById(workExperience.getId());

        if(workExperienceOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            workExperienceRepository.save(workExperience);
            return new ArrayList<>(Arrays.asList("Editado correcatmente", 200));
        }

    }

    public ArrayList<Object> deleteWorkExperience(Long id){
        Optional<WorkExperience> workExperienceOptional = workExperienceRepository.findById(id);

        if(workExperienceOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            workExperienceRepository.deleteById(id);
            return new ArrayList<>(Arrays.asList("Eliminado correcatmente", 200));
        }
    }

}
