package com.project.siret.service.siret;

import com.project.siret.data.domain_object.Siret;

import java.util.List;

public interface SiretService {

    Siret create(Siret siret);
    List<Siret> saveListSiret(List<Siret> siretList);

    void getSiretInfosAndStore();

}
