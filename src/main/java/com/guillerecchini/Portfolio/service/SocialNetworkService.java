package com.guillerecchini.Portfolio.service;

import com.guillerecchini.Portfolio.model.SocialNetwork;
import com.guillerecchini.Portfolio.repository.SocialNetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class SocialNetworkService {
    @Autowired
    SocialNetworkRepository socialNetworkRepository;

    public ArrayList<Object> newSocialNetwork(SocialNetwork socialNetwork){
        socialNetworkRepository.save(socialNetwork);
        return new ArrayList<>(Arrays.asList("Creado correcatmente", 200));
    }

    public SocialNetwork getSocialNetwork(Long id){
        return socialNetworkRepository.findById(id).orElse(null);
    }

    public ArrayList<Object> editSocialNetwork(SocialNetwork socialNetwork){

        Optional<SocialNetwork> socialNetworkOptional = socialNetworkRepository.findById(socialNetwork.getId());

        if(socialNetworkOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            socialNetworkRepository.save(socialNetwork);
            return new ArrayList<>(Arrays.asList("Editado correcatmente", 200));
        }

    }

    public ArrayList<Object> deleteSocialNetwork(Long id){
        Optional<SocialNetwork> socialNetworkOptional = socialNetworkRepository.findById(id);

        if(socialNetworkOptional.isEmpty()){
            return new ArrayList<>(Arrays.asList("No se encontró",403));
        }else {
            socialNetworkRepository.deleteById(id);
            return new ArrayList<>(Arrays.asList("Eliminado correcatmente", 200));
        }
    }

}
