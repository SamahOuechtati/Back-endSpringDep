package com.sagem.depannage.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "alertes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alertes {
    @ManyToOne
    Employers employer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlerte")
    long idAlerte;

    String nomDepanneur;
    String Poste;

    String typedefaut;
    String causeD;
    String Description;

}
