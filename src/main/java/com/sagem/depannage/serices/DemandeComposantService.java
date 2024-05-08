package com.sagem.depannage.serices;

import com.sagem.depannage.entities.DemandeComposant;
import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.repository.DemandecomposantRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class DemandeComposantService implements  IDemandeComposant{



    DemandecomposantRepository dmd;


    @Override
    public List<DemandeComposant> affichercoposant() {
        return dmd.findAll();
    }

    @Override
    public DemandeComposant addComposant(DemandeComposant d ){
         return dmd.save(d) ;


    }
}
