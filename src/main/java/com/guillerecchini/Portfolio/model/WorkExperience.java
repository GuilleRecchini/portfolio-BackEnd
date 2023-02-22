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
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="WorkExperiences")
public class WorkExperience {
    
    @Id
    @Column(name="id_work_experience")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String position;
    private String description;
    private Date startDate;
    private Date endDate;
    private String company;
    private String image;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;

    public WorkExperience() {
    }

    public WorkExperience(Long id, String position, String description, Date startDate, Date endDate, String company, String image, User user) {
        this.id = id;
        this.position = position;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.company = company;
        this.image = image;
        this.user = user;
    }
}
