package com.sagem.depannage.controllers;

import com.sagem.depannage.entities.Passation;
import com.sagem.depannage.serices.EmployeService;
import com.sagem.depannage.serices.Passationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/passation")
public class PassationControlleur {


    @Autowired
    Passationservice pass;
    @Autowired
    EmployeService emp;

    @PostMapping("/ajoutPass/{prenom}/{nom}")
    public Passation createPassation(@PathVariable String prenom,@PathVariable String nom,@RequestBody Passation passation) {
        return pass.createPassation(prenom,nom, passation);
    }

    @GetMapping("/{employe}")
    List<Passation> AfficherPassationByNom(@PathVariable String employe){
        return pass.AfficherPassationByNom(employe);

    }


    @PostMapping("/addPAssation")
    void addPassation (@RequestBody Passation e){
        pass.addPassation(e);

    }


    @DeleteMapping("{id}")
    void   suppById(@PathVariable Long id) {
        pass.removePassation(id);
    }
    @GetMapping
    public List<Passation> GetAllPass(){
        return pass.retrieveAllPass();
    }

    @GetMapping("/recherchePassPoste/{ouvrier}")
    public List<Passation> getPassationsByOuvrier(@PathVariable String ouvrier) {
        return pass.getPassationsByOuvrier(ouvrier);
    }
    @DeleteMapping("/supptouspassation")
    public void suppttAlertes(){
        pass.suppttpass();
    }


    @GetMapping("/rechercherParDates")
    public List<Passation> findPassParDates(@RequestParam("dateDebut") String dateDebut,@RequestParam("dateFin") String dateFin){
        LocalDate debut = LocalDate.parse(dateDebut);
        LocalDate fin = LocalDate.parse(dateFin);
        return pass.rechercherPassationsParDates(debut, fin);
    }
    @GetMapping("/last10")
    public List<Passation> getLast10Passations() {
        return pass.getLast10Passations();
    }

}
