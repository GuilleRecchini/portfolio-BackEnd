package com.guillerecchini.Portfolio.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    
    @ManyToOne
    @JoinColumn(name="id_user")
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
