package com.test.arkon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.test.arkon.model.FetchDataAlcaldia;

/**
 * Interfaz que permitira persistir detalle de la informacion de alcaldias
 * 
 * @author nodez
 *
 */
@Transactional
public interface FetchAlcaldiaRepository extends JpaRepository<FetchDataAlcaldia, Long> {

}
