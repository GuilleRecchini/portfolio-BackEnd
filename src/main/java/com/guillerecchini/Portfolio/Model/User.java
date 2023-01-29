package com.guillerecchini.Portfolio.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="Users")
public class User {
    
    @Id
    @Column(name="id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    @Column(columnDefinition = "TEXT")
    private String about;
    private String image;

    @OneToMany(mappedBy="user", fetch= FetchType.EAGER)
    private Set<SocialNetwork> listSocialNetworks = new HashSet<>();
    
    @OneToMany(mappedBy="user", fetch= FetchType.EAGER)
    private Set<Project> listProjects = new HashSet<>();
    
    @OneToMany(mappedBy="user", fetch= FetchType.EAGER)
    private Set<Skill> listSkills = new HashSet<>();

    @OneToMany(mappedBy="user", fetch= FetchType.EAGER)
    @JsonManagedReference
    private Set<WorkExperience> listWorkExperience = new HashSet<>();

    @OneToMany(mappedBy="user", fetch= FetchType.EAGER)
    private Set<Education> listEducation = new HashSet<>();

    public User() {
    }

    public User(Long id, String userName, String password, String email, String firstName, String lastName, String about, String image, Set<SocialNetwork> listSocialNetworks, Set<Project> listProjects, Set<Skill> listSkills, Set<WorkExperience> listWorkExperience, Set<Education> listEducation) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.about = about;
        this.image = image;
        this.listSocialNetworks = listSocialNetworks;
        this.listProjects = listProjects;
        this.listSkills = listSkills;
        this.listWorkExperience = listWorkExperience;
        this.listEducation = listEducation;
    }
}
