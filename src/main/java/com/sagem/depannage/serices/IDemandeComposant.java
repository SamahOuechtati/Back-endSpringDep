package com.sagem.depannage.serices;

import com.sagem.depannage.entities.DemandeComposant;
import com.sagem.depannage.entities.Employers;

import java.util.List;

public interface IDemandeComposant {

    List<DemandeComposant> affichercoposant();
    DemandeComposant addComposant (DemandeComposant d);
}
