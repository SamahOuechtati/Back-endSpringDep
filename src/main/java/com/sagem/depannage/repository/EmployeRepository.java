package com.sagem.depannage.repository;

import com.sagem.depannage.entities.Employers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employers, Long>{

  Employers findByCin(long cin);
@Query("SELECT e FROM Employers e WHERE e.prenom = :prenom AND e.nom = :nom")

    List<Employers> findFirstByPrenomAndNom(String prenom,String nom);
    @Query("SELECT e FROM Employers e WHERE e.prenom = :prenom ")

    List<Employers> findByPrenom(String prenom);

    @Query("SELECT e FROM Employers e WHERE e.typeUtilisation = :typeUtilisation")
    List<Employers> findByTypeUtilisation( String typeUtilisation);

    @Query("SELECT e FROM Employers e WHERE e.cin = :cin ")

    List<Employers> findBycin(long cin);

}
