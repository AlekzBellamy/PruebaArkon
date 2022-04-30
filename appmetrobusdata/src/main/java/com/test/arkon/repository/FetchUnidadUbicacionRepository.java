package com.test.arkon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.test.arkon.model.FetchDataUbicacionUnidad;

/**
 * Interfaz que permitira persistir detalle de la informacion de unidades 
 * 
 * @author nodez
 *
 */
@Transactional
public interface FetchUnidadUbicacionRepository extends JpaRepository<FetchDataUbicacionUnidad, Long> {

}
