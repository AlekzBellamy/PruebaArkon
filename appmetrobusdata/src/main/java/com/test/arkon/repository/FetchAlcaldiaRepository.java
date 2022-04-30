package com.test.arkon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.arkon.model.FetchDataAlcaldia;

/**
 * Interfaz que permitira persistir detalle de la informacion que se persistira
 * 
 * @author nodez
 *
 */
public interface FetchAlcaldiaRepository extends JpaRepository<FetchDataAlcaldia, Long> {

	
}
