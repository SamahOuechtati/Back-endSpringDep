package com.sagem.depannage.repository;

import com.sagem.depannage.entities.Employers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employers, Long>{
}
