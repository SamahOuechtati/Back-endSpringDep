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

    @GetMapping("/{typeUtil}")
    public List <Employers> afficherEmpParType(@PathVariable String typeUtil) {
        return emp.findAllByTypeUtilisation(typeUtil);
    }
    @GetMapping("/rechercheEmpCin/{cin}")
    public List <Employers> afficherEmpParType(@PathVariable long cin) {
        return emp.afficherEmpParCin(cin);
    }

    @PostMapping ("/AddEmployer")
    public  List<Employers> AddEmploye (@RequestBody Employers e){
        return  emp.addEmploye(e);
    }

    @DeleteMapping("/{cin}")
    List<Employers>  suppEmp (@PathVariable long cin ){
          return emp.suppEmploye(cin);}

    @PutMapping("/ModifierEmpl/{cin}")
     Employers updateEmployee(@PathVariable("cin") long cin, @RequestBody Employers employ) {
        return emp.updateEmployee(cin,employ);

    }

}
