package com.test.arkon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.arkon.model.Alcaldia;
import com.test.arkon.model.UbicacionUnidad;

public interface UnidadesDisponiblesRepository extends JpaRepository<UbicacionUnidad, Long> {

	
	/**
	 * Metodo para obtener las unidades por estatus
	 * @param estatus
	 * @return
	 */
	@Query("SELECT u FROM UbicacionUnidad u WHERE u.estatus  =:estatus")
	List<UbicacionUnidad> findByEstatus(@Param("estatus") long estatus);
	
	
	/**
	 * Metodo para obtener las unidades por estatus y por id de la unidad vehiculo
	 * @param estatus
	 * @param idVehiculo
	 * @return
	 */
	@Query("SELECT u FROM UbicacionUnidad u WHERE u.estatus  =:estatus and u.idVehiculo =:idVehiculo")
	List<UbicacionUnidad> findByEstatusAndIdVehicle(
			@Param("estatus") long estatus, 
			@Param("idVehiculo") long idVehiculo);
	
	/**
	 * Metodo para obtener todas las unidades
	 * @return
	 */
	List<UbicacionUnidad> findAll();
}
