package com.test.arkon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.arkon.model.DataMbCdmxAlcaldia;
import com.test.arkon.model.DataMbCdmxUnidadUbicacion;
import com.test.arkon.model.ResponseDataMbCdmx;
import com.test.arkon.service.MetroBusDataService;

/**
 * Controlador para ejecutar de forma manual el inicio de persistencia de
 * informacion a BD
 * 
 * @author nodez
 *
 */
@CrossOrigin(origins = "http://localhost:7001")
@RestController
@RequestMapping("/data")
public class Controller {

	public final static Logger LOG = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private MetroBusDataService busDataService;

	/**
	 * Metodo para hacer llamado del consumo de CDMX DATA Alcaldias
	 * 
	 * @return
	 */
	@GetMapping(value = "/consultaAlcaldias")
	public ResponseEntity<ResponseDataMbCdmx<DataMbCdmxAlcaldia>> getAllAlcaldias() {
		try {
			ResponseDataMbCdmx<DataMbCdmxAlcaldia> response = busDataService.obtenerAlcaldiasMbCdmx();
			LOG.info("alcladias DATA CDMX recuperadas : {}", response.getResult().getRecords());
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Error al probar consultar alcladias DATA CDMX", e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Metodo para hacer llamado del consumo de CDMX DATA Unidades
	 * 
	 * @return
	 */

	@GetMapping(value = "/consultaUnidades")
	public ResponseEntity<ResponseDataMbCdmx<DataMbCdmxUnidadUbicacion>> getAllUnidades() {
		try {
			ResponseDataMbCdmx<DataMbCdmxUnidadUbicacion> response = busDataService.obtenerUnidadesMbCdmx();
			LOG.info("unidades DATA CDMX recuperadas : {}", response.getResult().getRecords());
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Error al probar consultar unidades DATA CDMX", e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Metodo para hacer llamado del consumo de CDMX DATA Alcaldias
	 * 
	 * @return
	 */

	@GetMapping(value = "/altaAlcaldias")
	public ResponseEntity<List<DataMbCdmxAlcaldia>> persistirAlcaldias() {
		try {
			List<DataMbCdmxAlcaldia> alcaldiasRegistradas = busDataService.almacenamientoAlcaldias();
			LOG.info("unidades DATA CDMX alcaldiasRegistradas : {}", alcaldiasRegistradas);
			return new ResponseEntity<>(alcaldiasRegistradas, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Error al registrarAlcaldias DATA CDMX", e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Metodo para hacer llamado del consumo de CDMX DATA Unidades
	 * 
	 * @return
	 */

	@GetMapping(value = "/altaUnidades")
	public ResponseEntity<List<DataMbCdmxUnidadUbicacion>> persistirUnidades() {
		try {
			List<DataMbCdmxUnidadUbicacion> unidadesRegistrados = busDataService.almacenamientoUnidades();
			LOG.info("unidades DATA CDMX unidadesRegistrados : {}", unidadesRegistrados);
			return new ResponseEntity<>(unidadesRegistrados, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Error al registrarUnidades DATA CDMX", e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
