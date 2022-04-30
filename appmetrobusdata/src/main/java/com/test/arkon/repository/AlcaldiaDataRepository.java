package com.test.arkon.repository;



import org.springframework.data.jpa.repository.JpaRepository;



import com.test.arkon.model.DataMbCdmxAlcaldia;

/**
 * Interfaz que permitira persistir la informacion de alcaldias
 * @author nodez
 *
 */
public interface AlcaldiaDataRepository extends JpaRepository<DataMbCdmxAlcaldia, Long> {


}
