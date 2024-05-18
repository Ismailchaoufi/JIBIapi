package com.ENSA.JIBI.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_compte;

    @Column(name="comptename",nullable = false)
    private String comptename="Checking Account";

    @Column(name="rib",nullable = false)
    private String rib;

    @Column(name="solde",nullable = true)
    private Double solde;

    @Column(name="type_compte")
    private String type_compte;






}