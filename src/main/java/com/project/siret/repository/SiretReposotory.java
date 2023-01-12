package com.project.siret.repository;

import com.project.siret.data.domain_object.Siret;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nicolas on 13/01/2023.
 */
public interface SiretReposotory extends JpaRepository<Siret, Integer> {
}
