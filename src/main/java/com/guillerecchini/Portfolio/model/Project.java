package com.guillerecchini.Portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="Projects")
public class Project {
    
    @Id
    @Column(name="id_project")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String name;
    private String description;
    private String image;
    private String url;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_user")
    @JsonBackReference
    private User user;

    public Project() {
    }

    public Project(Long id, String name, String description, String image, String url, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.url = url;
        this.user = user;
    }
}
