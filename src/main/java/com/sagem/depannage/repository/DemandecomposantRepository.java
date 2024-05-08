package com.sagem.depannage.repository;

import com.sagem.depannage.entities.Alertes;
import com.sagem.depannage.entities.DemandeComposant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandecomposantRepository extends JpaRepository<DemandeComposant, Long> {

}
