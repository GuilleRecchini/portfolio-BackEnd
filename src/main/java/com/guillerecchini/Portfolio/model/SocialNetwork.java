package com.guillerecchini.Portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="SocialNetworks")
public class SocialNetwork {
    
    @Id
    @Column(name="Id_Red")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String name;
    private String image;
    private String url;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_user")
    @JsonBackReference
    private User user;

    public SocialNetwork() {
    }

    public SocialNetwork(Long id, String name, String image, String url, User user) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.url = url;
        this.user = user;
    }
}
