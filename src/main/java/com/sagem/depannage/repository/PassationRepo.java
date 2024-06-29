package com.sagem.depannage.repository;

import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.entities.Passation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PassationRepo extends JpaRepository<Passation,Long> {


    @Query("SELECT e FROM Passation e WHERE e.ouvrier = :employe")
    List<Passation> findByNomEmploye(String employe);

    List<Passation> deleteByIdPassation(long idPassation);

    @Query("SELECT p FROM Passation p WHERE p.ouvrier = :ouvrier")
    List<Passation> findByOuvrier(String ouvrier);

    List<Passation> findByDatejourBetween(LocalDate dateDebut, LocalDate dateFin);

    List<Passation> findTop10ByOrderByDatejourDesc();
}
