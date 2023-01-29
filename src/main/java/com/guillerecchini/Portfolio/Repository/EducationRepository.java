package com.guillerecchini.Portfolio.Repository;

import com.guillerecchini.Portfolio.Model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>{
    
}