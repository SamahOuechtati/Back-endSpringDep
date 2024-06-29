package com.sagem.depannage.serices;

import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.entities.Passation;
import com.sagem.depannage.repository.EmployeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

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
    public List<Employers> suppEmploye(long cin) {
        Employers employe = emp.findByCin(cin); // Trouver l'employé par son cin
        if (employe != null) {
            emp.delete(employe); // Supprimer l'employé trouvé
        }
        return emp.findAll(); // Récupérer et renvoyer la liste mise à jour des employés
    }

    @Override
    public List<Employers> findAllByTypeUtilisation(String typeUtilisation) {
        return emp.findByTypeUtilisation(typeUtilisation);
    }

    @Override
    public Employers updateEmployee(long cin, Employers employeeDetails) {
        // Rechercher l'employé par son cin
        Optional<Employers> employeeOptional = Optional.ofNullable(emp.findByCin(cin));

        // Vérifier si l'employé existe
        if (employeeOptional.isPresent()) {
            Employers employee = employeeOptional.get();

            // Mettre à jour les détails de l'employé avec les nouvelles valeurs
            employee.setNom(employeeDetails.getNom());
            employee.setPrenom(employeeDetails.getPrenom());
            employee.setFonction(employeeDetails.getFonction());
            employee.setDatenaissance(employeeDetails.getDatenaissance());
            employee.setTypeUtilisation(employeeDetails.getTypeUtilisation());

            // Sauvegarder les modifications dans la base de données
            return emp.save(employee);
        } else {
            // Gérer le cas où l'employé n'est pas trouvé
            throw new RuntimeException("Employee not found with cin: " + cin);
        }
    }

    @Override
    public List<Employers> afficherEmpParCin(long cin) {
        return emp.findBycin(cin);

    }

}
