package com.sagem.depannage.serices;

import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.repository.EmployeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class EmployeService implements   IEmployeService{

    EmployeRepository emp;
    @Override
    public List<Employers> AfficherTousEmployes() {
        return emp.findAll();
    }

    @Override
    public List<Employers> addEmploye(Employers e) {
         emp.save(e);
        return emp.findAll();
    }



    @Override
    public List<Employers> suppEmploye(long idEmploy) {
        emp.deleteById(idEmploy); // Supprime un employé en utilisant l'ID fourni
        return emp.findAll(); // Récupère et renvoie la liste mise à jour des employés
    }






}
