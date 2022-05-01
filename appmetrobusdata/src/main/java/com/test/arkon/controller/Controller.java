package com.test.arkon.controller;

import java.util.ArrayList;
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
import com.test.arkon.model.Respuesta;
import com.test.arkon.service.MetroBusDataService;
import com.test.arkon.util.enums.ResultadoCodigo;

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
	public ResponseEntity<Respuesta<ResponseDataMbCdmx<DataMbCdmxAlcaldia>>> getAllAlcaldias() {
		Respuesta<ResponseDataMbCdmx<DataMbCdmxAlcaldia>> respuesta = new Respuesta<ResponseDataMbCdmx<DataMbCdmxAlcaldia>>();
		try {
			ResponseDataMbCdmx<DataMbCdmxAlcaldia> response = busDataService.obtenerAlcaldiasMbCdmx();
			LOG.info("alcladias DATA CDMX recuperadas : {}", response.getResult().getRecords());
			respuesta.setResultado(response);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setCodigo(ResultadoCodigo.INCORRECTO_PROCESO.getId());
			respuesta.setDescripcion(ResultadoCodigo.INCORRECTO_PROCESO.getDescripcion());
			LOG.error("Error al probar consultar alcladias DATA CDMX", e);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Metodo para hacer llamado del consumo de CDMX DATA Unidades
	 * 
	 * @return
	 */

	@GetMapping(value = "/consultaUnidades")
	public ResponseEntity<Respuesta<ResponseDataMbCdmx<DataMbCdmxUnidadUbicacion>>> getAllUnidades() {
		Respuesta<ResponseDataMbCdmx<DataMbCdmxUnidadUbicacion>> respuesta = new Respuesta<ResponseDataMbCdmx<DataMbCdmxUnidadUbicacion>>();
		try {
			ResponseDataMbCdmx<DataMbCdmxUnidadUbicacion> response = busDataService.obtenerUnidadesMbCdmx();
			LOG.info("unidades DATA CDMX recuperadas : {}", response.getResult().getRecords());
			respuesta.setResultado(response);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setCodigo(ResultadoCodigo.INCORRECTO_PROCESO.getId());
			respuesta.setDescripcion(ResultadoCodigo.INCORRECTO_PROCESO.getDescripcion());
			LOG.error("Error al probar consultar unidades DATA CDMX", e);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Metodo para hacer llamado del consumo de CDMX DATA Alcaldias
	 * 
	 * @return
	 */

	@GetMapping(value = "/altaAlcaldias")
	public ResponseEntity<Respuesta<List<DataMbCdmxAlcaldia>>> persistirAlcaldias() {
		Respuesta<List<DataMbCdmxAlcaldia>> respuesta = new Respuesta<List<DataMbCdmxAlcaldia>>();
		try {
			List<DataMbCdmxAlcaldia> alcaldiasRegistradas = busDataService.almacenamientoAlcaldias();
			LOG.info("unidades DATA CDMX alcaldiasRegistradas : {}", alcaldiasRegistradas);
			respuesta.setResultado(alcaldiasRegistradas);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setCodigo(ResultadoCodigo.INCORRECTO_PROCESO.getId());
			respuesta.setDescripcion(ResultadoCodigo.INCORRECTO_PROCESO.getDescripcion());
			respuesta.setResultado(new ArrayList<>());
			LOG.error("Error al registrarAlcaldias DATA CDMX", e);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Metodo para hacer llamado del consumo de CDMX DATA Unidades
	 * 
	 * @return
	 */

	@GetMapping(value = "/altaUnidades")
	public ResponseEntity<Respuesta<List<DataMbCdmxUnidadUbicacion>>> persistirUnidades() {
		Respuesta<List<DataMbCdmxUnidadUbicacion>> respuesta = new Respuesta<List<DataMbCdmxUnidadUbicacion>>();
		try {
			List<DataMbCdmxUnidadUbicacion> unidadesRegistrados = busDataService.almacenamientoUnidades();
			LOG.info("unidades DATA CDMX unidadesRegistrados : {}", unidadesRegistrados);
			respuesta.setResultado(unidadesRegistrados);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setCodigo(ResultadoCodigo.INCORRECTO_PROCESO.getId());
			respuesta.setDescripcion(ResultadoCodigo.INCORRECTO_PROCESO.getDescripcion());
			respuesta.setResultado(new ArrayList<>());
			LOG.error("Error al registrarUnidades DATA CDMX", e);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
