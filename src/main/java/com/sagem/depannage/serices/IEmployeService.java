package com.sagem.depannage.serices;

import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.entities.Passation;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IEmployeService {

    List<Employers> AfficherTousEmployes();

    List<Employers> addEmploye (Employers e);

  List<Employers> suppEmploye(long cin);

    List<Employers> findAllByTypeUtilisation(String typeUtilisation);

    public Employers updateEmployee(long cin, Employers employeeDetails);
    List<Employers> afficherEmpParCin( long cin);
}
