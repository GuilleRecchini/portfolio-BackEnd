package com.guillerecchini.Portfolio.Repository;

import com.guillerecchini.Portfolio.Model.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworkRepository extends JpaRepository<SocialNetwork, Long>{
    
}
