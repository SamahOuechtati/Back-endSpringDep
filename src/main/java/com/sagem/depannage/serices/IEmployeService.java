package com.sagem.depannage.serices;

import com.sagem.depannage.entities.Employers;

import java.util.List;

public interface IEmployeService {

    List<Employers> AfficherTousEmployes();
    List<Employers> addEmploye (Employers e);

  List<Employers> suppEmploye(long idEmploy);

}
