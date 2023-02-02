package com.guillerecchini.Portfolio.Service;

import com.guillerecchini.Portfolio.Model.Skill;
import com.guillerecchini.Portfolio.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class SkillService {
    @Autowired
    SkillRepository skillRepository;

    public ArrayList<Object> newSkill(Skill skill){
        skillRepository.save(skill);
        return new ArrayList<>(Arrays.asList("Creado correcatmente", 200));
    }

    public Skill getSkill(Long id){
        return skillRepository.findById(id).orElse(null);
    }

    public ArrayList<Object> editSkill(Skill skill){

        Optional<Skill> skillOptional = skillRepository.findById(skill.getId());

        if(skillOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            skillRepository.save(skill);
            return new ArrayList<>(Arrays.asList("Editado correcatmente", 200));
        }

    }

    public ArrayList<Object> deleteSkill(Long id){
        Optional<Skill> skillOptional = skillRepository.findById(id);

        if(skillOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            skillRepository.deleteById(id);
            return new ArrayList<>(Arrays.asList("Eliminado correcatmente", 200));
        }
    }
}
