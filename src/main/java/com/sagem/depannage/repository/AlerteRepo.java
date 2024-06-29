package com.sagem.depannage.repository;

import com.sagem.depannage.entities.Alertes;
import com.sagem.depannage.entities.Employers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlerteRepo extends JpaRepository<Alertes, Long> {

    @Query("SELECT e FROM Alertes e WHERE e.nomDepanneur = :nomDep")
List<Alertes> findByNom(String nomDep);

}
