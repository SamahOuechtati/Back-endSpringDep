package com.sagem.depannage.serices;

import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.entities.Passation;

import java.time.LocalDate;
import java.util.List;

public interface IPassationService {


    List<Passation> AfficherPassationByNom(String nomEmploye);

    void addPassation(Passation e);

    void removePassation(long idPassation);

    List<Passation> retrieveAllPass();

    public Passation createPassation(String prenom,String nom, Passation passation);
    public List<Passation> getPassationsByOuvrier(String ouvrier);

    public void  suppttpass();
    public List<Passation> rechercherPassationsParDates(LocalDate dateDebut, LocalDate dateFin);

    public List<Passation> getLast10Passations();
}
