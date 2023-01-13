package com.project.siret.repository;

import com.project.siret.data.domain_object.Siret;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository For Siret
 *
 * @author  Nicolas Razanatsimba
 * @version 1.0
 * @since   2023-01-13
 */
public interface SiretReposotory extends JpaRepository<Siret, Integer> {
}
