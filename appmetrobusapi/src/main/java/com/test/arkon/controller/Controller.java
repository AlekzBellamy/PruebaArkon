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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.arkon.model.Alcaldia;
import com.test.arkon.model.Respuesta;
import com.test.arkon.model.UbicacionUnidad;
import com.test.arkon.repository.AlcaldiaRepository;
import com.test.arkon.repository.UnidadesDisponiblesRepository;
import com.test.arkon.util.BusquedaCordenadas;
import com.test.arkon.util.enums.ResultadoCodigo;

@CrossOrigin(origins = "http://localhost:7001")
@RestController
@RequestMapping("/api")
public class Controller {

	public final static Logger LOG = LoggerFactory.getLogger(Controller.class);
	@Autowired
	AlcaldiaRepository alcaldiaRepository;

	@Autowired
	UnidadesDisponiblesRepository unidadesDisponiblesRepository;

	@GetMapping(value = "/alcaldias")
	public ResponseEntity<Respuesta<List<Alcaldia>>> getAllAlcaldias() {
		Respuesta<List<Alcaldia>> respuesta = new Respuesta<List<Alcaldia>>();
		try {
			List<Alcaldia> alcaldias = alcaldiaRepository.findByEstatus(1L);

			LOG.info("Alcaldias recuperadas : {}", alcaldias.size());
			respuesta.setResultado(alcaldias);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setCodigo(ResultadoCodigo.INCORRECTO_PROCESO.getId());
			respuesta.setDescripcion(ResultadoCodigo.INCORRECTO_PROCESO.getDescripcion());
			respuesta.setResultado(new ArrayList<>());
			LOG.error("Error al recuperar Alcaldias recuperadas", e);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/unidades")
	public ResponseEntity<Respuesta<List<UbicacionUnidad>>> getAllUnidades() {
		Respuesta<List<UbicacionUnidad>> respuesta = new Respuesta<List<UbicacionUnidad>>();
		try {
			List<UbicacionUnidad> unidades = unidadesDisponiblesRepository.findByEstatus(1L);
			LOG.info("Unidades recuperadas : {}", unidades.size());
			respuesta.setResultado(unidades);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setCodigo(ResultadoCodigo.INCORRECTO_PROCESO.getId());
			respuesta.setDescripcion(ResultadoCodigo.INCORRECTO_PROCESO.getDescripcion());
			respuesta.setResultado(new ArrayList<>());
			LOG.info("Error al recuperar unidades recuperadas", e);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/unidades/{id}")
	public ResponseEntity<Respuesta<List<UbicacionUnidad>>> getUnidadesById(@PathVariable("id") Integer id) {
		Respuesta<List<UbicacionUnidad>> respuesta = new Respuesta<List<UbicacionUnidad>>();
		try {
			List<UbicacionUnidad> unidades = unidadesDisponiblesRepository.findByEstatusAndIdVehicle(1L, id);
			LOG.info("Unidades recuperadas : {}", unidades.size());
			respuesta.setResultado(unidades);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setCodigo(ResultadoCodigo.INCORRECTO_PROCESO.getId());
			respuesta.setDescripcion(ResultadoCodigo.INCORRECTO_PROCESO.getDescripcion());
			respuesta.setResultado(new ArrayList<>());
			LOG.error("Error al recuperar unidades recuperadas", e);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/unidades/alcaldia/{id}")
	public ResponseEntity<Respuesta<List<UbicacionUnidad>>> getAllUnidadesByIdAlcaldia(@PathVariable("id") Integer id) {
		Respuesta<List<UbicacionUnidad>> respuesta = new Respuesta<List<UbicacionUnidad>>();
		try {
			Alcaldia alcaldia = alcaldiaRepository.findByEstatusAndId(1L, id);
			List<UbicacionUnidad> unidades = unidadesDisponiblesRepository.findByEstatus(1L);
			List<UbicacionUnidad> unidadesFiltro = new ArrayList<>();
			for (UbicacionUnidad ubicacionUnidad : unidades) {
				if (BusquedaCordenadas.existeUnidadEnAlcaldia(ubicacionUnidad.getGeolocalizacionPoint(),
						alcaldia.getGeolocalizacionShape())) {
					unidadesFiltro.add(ubicacionUnidad);

				}
			}
			LOG.info("Unidades recuperadas : {}", unidadesFiltro.size());
			respuesta.setResultado(unidadesFiltro);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setCodigo(ResultadoCodigo.INCORRECTO_PROCESO.getId());
			respuesta.setDescripcion(ResultadoCodigo.INCORRECTO_PROCESO.getDescripcion());
			respuesta.setResultado(new ArrayList<>());
			LOG.info("Error al recuperar unidades recuperadas", e);
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
