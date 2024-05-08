package com.sagem.depannage.serices;

import com.sagem.depannage.entities.Alertes;
import com.sagem.depannage.entities.Employers;

import java.util.List;

public interface IAlerteservice {

    List<Alertes> AfficherTousAlt();
    List<Alertes> addAlt(Alertes a);

    List<Alertes> suppAlt(long idAlerte);
}
