package com.sagem.depannage.controllers;


import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.serices.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employees")
public class EmployeConrolles {


    @Autowired
    EmployeService emp;

    @GetMapping
    public List<Employers> AfficheEmploy(){
            return emp.AfficherTousEmployes();
    }

    @PostMapping ("/AddEmployer")
    public  List<Employers> AddEmploye (@RequestBody Employers e){
        return  emp.addEmploye(e);
    }

    @DeleteMapping("{id}")
    List<Employers>  suppEmp (@PathVariable long id ){
          return emp.suppEmploye(id);}



}
