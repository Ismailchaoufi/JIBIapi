package com.ENSA.JIBI.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Client {





    @Id
    @GeneratedValue
    private Long id_client;
    @Column(name = "username",unique = true,nullable = false,updatable = false)
    private String username;
    @Column(name = "nom",nullable = false)
    private String nom;

    @Column(name = "prenom",nullable = false)
    private String prenom;

    @Column(name = "numTel",nullable = false)
    private  String numTel;


    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name="password",nullable = false)
    private String password;


    @Column(name="firstAuth",nullable = false)
    private Boolean firstAuth = true;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_compte")
    private Compte compte;

    @Column(name="role")
    private String role = "ROLE_CLIENT";





}

