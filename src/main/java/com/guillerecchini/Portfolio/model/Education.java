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
@Table(name="Education")
public class Education {
    
    @Id
    @Column(name="id_education")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String degree;
    private String description;
    private Date startDate;
    private Date endDate;
    private String institution;
    private String image;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_user")
    @JsonBackReference
    private User user;

    public Education() {
    }

    public Education(Long id, String degree, String description, Date startDate, Date endDate, String institution, String image, User user) {
        this.id = id;
        this.degree = degree;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.institution = institution;
        this.image = image;
        this.user = user;
    }
}
