package com.sagem.depannage.serices;

import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.entities.Passation;
import com.sagem.depannage.repository.EmployeRepository;
import com.sagem.depannage.repository.PassationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class Passationservice implements IPassationService{

    @Autowired
    PassationRepo pasrep;
    @Autowired
    EmployeRepository emp;

    @Override
    public List<Passation> AfficherPassationByNom(String employe) {
       List<Passation> result= pasrep.findByNomEmploye(employe);
        return result;
    }

    @Override
    public void addPassation(Passation e) {
         pasrep.save(e);
    }

    @Override
    public void removePassation(long idPassation) {
        pasrep.deleteById(idPassation);

    }

    @Override
    public List<Passation> retrieveAllPass() {
        return pasrep.findAll();
    }
    @Override
    public Passation createPassation(String prenom,String nom, Passation passation) {
        List<Employers> employers = emp.findFirstByPrenomAndNom(prenom,nom);
        if (!employers.isEmpty()) {
            Employers employer = employers.get(0); // Prenez le premier employé trouvé
            passation.setEmployer(employer);
            return pasrep.save(passation);
        } else {
            throw new RuntimeException("Employé non trouvé");

        }
    }
    @Override
    public List<Passation> getPassationsByOuvrier(String ouvrier) {
        return pasrep.findByOuvrier(ouvrier);
    }

    @Override
    public void  suppttpass(){
        pasrep.deleteAll();
    }

    @Override
    public List<Passation> rechercherPassationsParDates(LocalDate dateDebut, LocalDate dateFin) {
        // Implémentez la logique pour récupérer les passations entre les dates spécifiées
        return pasrep.findByDatejourBetween(dateDebut, dateFin);
    }
@Override
    public List<Passation> getLast10Passations() {
        return pasrep.findTop10ByOrderByDatejourDesc();
    }


}
