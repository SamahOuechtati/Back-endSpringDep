package com.sagem.depannage.controllers;

import com.sagem.depannage.entities.Alertes;
import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.serices.AlerteService;
import com.sagem.depannage.serices.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alertes")

public class AlerteContolleur {

    @Autowired
    AlerteService alt;

    @GetMapping
    public List<Alertes> AfficheAlt(){
        return alt.AfficherTousAlt();
    }

    @PostMapping("/AddAlerte")
    public  List<Alertes> AddAlt (@RequestBody Alertes a){
        return  alt.addAlt(a);
    }

    @DeleteMapping("{id}")
    List<Alertes>  suppAlt (@PathVariable long id ){
        return alt.suppAlt(id);}
}
