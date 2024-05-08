package com.sagem.depannage.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "demandecomposant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DemandeComposant {

    @ManyToOne
    Employers employer;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDemande")
    long idDemande;
    String nom;

    String prenom;
    String matricule;
    @Temporal(TemporalType.DATE)
    LocalDate  datejour;
    String reference;
    String designation;
    String quantite;
    String cause;




}
