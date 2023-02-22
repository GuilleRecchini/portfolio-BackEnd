package com.guillerecchini.Portfolio.repository;

import com.guillerecchini.Portfolio.model.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long>{
    
}
