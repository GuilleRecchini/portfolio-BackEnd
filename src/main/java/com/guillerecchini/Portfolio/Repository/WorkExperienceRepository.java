package com.guillerecchini.Portfolio.Repository;

import com.guillerecchini.Portfolio.Model.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long>{
    
}
