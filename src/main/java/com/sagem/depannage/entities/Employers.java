package com.sagem.depannage.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employers  {


    @OneToMany
    List<DemandeComposant> demandeC;
    @OneToMany
    List <Alertes>alerte;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Passation>pass;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmploye")
    long idEmploye;
    String nom;

    String prenom;
    long cin;
    String fonction;
    Date datenaissance;
    @Column(name = "type_utilisation")
    private String typeUtilisation;



}


