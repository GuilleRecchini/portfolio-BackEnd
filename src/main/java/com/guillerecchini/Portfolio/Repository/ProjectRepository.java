package com.guillerecchini.Portfolio.Repository;

import com.guillerecchini.Portfolio.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}
