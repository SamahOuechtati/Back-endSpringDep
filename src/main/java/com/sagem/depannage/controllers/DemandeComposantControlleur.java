package com.sagem.depannage.controllers;

import com.sagem.depannage.entities.Alertes;
import com.sagem.depannage.entities.DemandeComposant;
import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.serices.IDemandeComposant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
    @RequestMapping("/demandecomposant")
public class DemandeComposantControlleur {
    @Autowired
    IDemandeComposant dmc;

    @GetMapping
    public  List<DemandeComposant> afficherCoposant(){
        return  dmc.affichercoposant();
    }

    @PostMapping("/ajoutDemandeCpt/{prenom}")
    public DemandeComposant crateDEmandeCpt(@PathVariable String prenom, @RequestBody DemandeComposant demCpt) {
        return dmc.createDeamndeCpt(prenom, demCpt);
    }

    @PostMapping("/demandecomposant")
    public DemandeComposant addComposant (@RequestBody DemandeComposant d){
        return dmc.addComposant(d);
    }


}


