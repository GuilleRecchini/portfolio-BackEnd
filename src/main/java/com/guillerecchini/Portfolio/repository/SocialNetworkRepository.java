package com.guillerecchini.Portfolio.repository;

import com.guillerecchini.Portfolio.model.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworkRepository extends JpaRepository<SocialNetwork, Long>{
    
}
