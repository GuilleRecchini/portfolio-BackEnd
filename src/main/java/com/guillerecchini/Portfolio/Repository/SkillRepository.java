package com.guillerecchini.Portfolio.Repository;

import com.guillerecchini.Portfolio.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{
    
}
