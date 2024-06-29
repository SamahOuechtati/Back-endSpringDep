package com.sagem.depannage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "passation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passation {
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "nom_employer")
    Employers employer;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPassation")
    long idPassation;
   String tache;
   String description;
   LocalDate datejour;
   String ouvrier;
}
