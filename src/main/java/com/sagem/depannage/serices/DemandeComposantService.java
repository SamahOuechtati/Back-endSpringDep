package com.sagem.depannage.serices;

import com.sagem.depannage.entities.DemandeComposant;
import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.repository.DemandecomposantRepository;
import com.sagem.depannage.repository.EmployeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class DemandeComposantService implements  IDemandeComposant{


    @Autowired
    DemandecomposantRepository dmd;
    @Autowired
    EmployeRepository emp;


    @Override
    public List<DemandeComposant> affichercoposant() {
        return dmd.findAll();
    }

    @Override
    public DemandeComposant addComposant(DemandeComposant d ){
         return dmd.save(d) ;


    }

    @Override
    public DemandeComposant createDeamndeCpt(String prenom, DemandeComposant demCpt) {
        List<Employers> employers = emp.findByPrenom(prenom);
        if (!employers.isEmpty()) {
            Employers employer = employers.get(0); // Prenez le premier employé trouvé
            demCpt.setEmployer(employer);
            return dmd.save(demCpt);
        } else {
            throw new RuntimeException("Employé non trouvé");

        }
    }


}
