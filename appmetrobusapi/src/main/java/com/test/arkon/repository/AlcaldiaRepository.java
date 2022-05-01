package com.test.arkon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.arkon.model.Alcaldia;

public interface AlcaldiaRepository extends JpaRepository<Alcaldia, Long>{
	
	/**
	 * Metodo para obtener las alcaldias por estatus
	 * @param estatus
	 * @return
	 */
	@Query("SELECT a FROM Alcaldia a WHERE a.estatus  =:estatus")
	List<Alcaldia> findByEstatus(@Param("estatus") long estatus);
	
	/**
	 * Metodo para obtener todas las alcaldias
	 * @return
	 */
	List<Alcaldia> findAll();
	
	/**
	 * Metodo para obtener las alcaldias por estatus
	 * @param estatus
	 * @return
	 */
	@Query("SELECT a FROM Alcaldia a WHERE a.estatus  =:estatus and a.id  =:id")
	Alcaldia findByEstatusAndId(@Param("estatus") long estatus, @Param("id") long id);

}
