package com.guillerecchini.Portfolio.Repository;

import com.guillerecchini.Portfolio.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    
}
