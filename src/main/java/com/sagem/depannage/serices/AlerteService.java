package com.sagem.depannage.serices;

import com.sagem.depannage.entities.Alertes;
import com.sagem.depannage.entities.Employers;
import com.sagem.depannage.repository.AlerteRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AlerteService implements  IAlerteservice{

    AlerteRepo alt;
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
}
