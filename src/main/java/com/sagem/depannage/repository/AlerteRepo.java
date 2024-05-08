package com.sagem.depannage.repository;

import com.sagem.depannage.entities.Alertes;
import com.sagem.depannage.entities.Employers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlerteRepo extends JpaRepository<Alertes, Long> {
}
