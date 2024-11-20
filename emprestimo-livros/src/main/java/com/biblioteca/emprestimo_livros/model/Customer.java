package com.biblioteca.emprestimo_livros.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String lastname;
    
    private String adress;
    private String city;
    
    @Column(nullable = false)
    private String state;
    
    private String country;
    
    private LocalDate birthDate;
    
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;
 
}
