package com.guillerecchini.Portfolio.service;

import com.guillerecchini.Portfolio.model.Education;
import com.guillerecchini.Portfolio.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class EducationService {
    @Autowired
    EducationRepository educationRepository;

    public ArrayList<Object> newEducation(Education education){
        educationRepository.save(education);
        return new ArrayList<>(Arrays.asList("Creado correcatmente", 200));
    }

    public Education getEducation(Long id){
        return educationRepository.findById(id).orElse(null);
    }

    public ArrayList<Object> editEducation(Education education){

        Optional<Education> educationOptional = educationRepository.findById(education.getId());

        if(educationOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            educationRepository.save(education);
            return new ArrayList<>(Arrays.asList("Editado correcatmente", 200));
        }

    }

    public ArrayList<Object> deleteEducation(Long id){
        Optional<Education> educationOptional = educationRepository.findById(id);

        if(educationOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            educationRepository.deleteById(id);
            return new ArrayList<>(Arrays.asList("Eliminado correcatmente", 200));
        }
    }


}
