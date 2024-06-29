package com.sagem.depannage.serices;

import com.sagem.depannage.entities.Alertes;
import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.repository.AlerteRepo;
import com.sagem.depannage.repository.EmployeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AlerteService implements  IAlerteservice{

    @Autowired
    AlerteRepo alt;
    @Autowired
    EmployeRepository emp;
    @Override
    public List<Alertes> AfficherTousAlt() {
        return alt.findAll();
    }

    @Override
    public List<Alertes> addAlt(Alertes a) {
         alt.save(a);
         return  alt.findAll();

    }

    @Override
    public List<Alertes> suppAlt(long idAlerte) {
        alt.deleteById(idAlerte);

        return alt.findAll();
    }
    @Override
public void  suppttalerte(){
         alt.deleteAll();
    }

    @Override
    public Alertes createalerte(String prenom, Alertes alerte) {
        List<Employers> employers = emp.findByPrenom(prenom);
        if (!employers.isEmpty()) {
            Employers employer = employers.get(0); // Prenez le premier employé trouvé
            alerte.setEmployer(employer);
            return alt.save(alerte);
        } else {
            throw new RuntimeException("Employé non trouvé");

        }
    }


    @Override
    public List<Alertes> AfficherLeurAlertes(String nomDep) {
        return alt.findByNom(nomDep);
    }
}
