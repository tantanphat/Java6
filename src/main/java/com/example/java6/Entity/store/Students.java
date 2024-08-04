package com.example.java6.Entity.store;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Students")
public class Students {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "marks")
    private Double marks;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "country")
    private String country;
}
