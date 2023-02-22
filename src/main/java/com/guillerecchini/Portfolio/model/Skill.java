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
@Table(name="Skills")
public class Skill {
    
    @Id
    @Column(name="id_skill")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String name;
    private String image;
    private Integer percentage;
    private Boolean isHard;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_user")
    @JsonBackReference
    private User user;

    public Skill() {
    }

    public Skill(Long id, String name, String image, Integer percentage, Boolean isHard, User user) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.percentage = percentage;
        this.isHard = isHard;
        this.user = user;
    }
}
