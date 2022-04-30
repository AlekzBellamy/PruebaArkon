package com.test.arkon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.test.arkon.model.DataMbCdmxAlcaldia;

/**
 * Interfaz que permitira persistir la informacion de alcaldias
 * 
 * @author nodez
 *
 */
@Transactional
public interface AlcaldiaDataRepository extends JpaRepository<DataMbCdmxAlcaldia, Long> {

	/**
	 * Metodo para dar de baja aquellas alcaldias que dejan de ser actuales
	 * 
	 * @param id_fetch_alcaldia
	 */
	@Modifying
	@Query("update DataMbCdmxAlcaldia d SET d.estatus = 2  where d.estatus=1 and d.id_fetch_alcaldia <> :id_fetch_alcaldia")
	void bajaAlcaldiasAnteriores(@Param("id_fetch_alcaldia") long id_fetch_alcaldia);

}
