package com.test.arkon.util;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.arkon.model.Geometry;

public class BusquedaCordenadas {

	public static final String COMA = ",";
	public final static Logger LOG = LoggerFactory.getLogger(BusquedaCordenadas.class);

	/**
	 * Metodo para validar si las cordenadas de la unidad existe en el alcance de la
	 * alcaldia
	 * 
	 * @param ubicacionUnidad
	 * @param jsonGeometryAlcaldia
	 * @return
	 */
	public static boolean existeUnidadEnAlcaldia(String ubicacionUnidad, String jsonGeometryAlcaldia) {
		try {
			ObjectMapper m = new ObjectMapper();
			Geometry geometry = m.readValue(jsonGeometryAlcaldia, new TypeReference<Geometry>() {
			});
			LOG.info("ubicacionUnidad : {}", ubicacionUnidad);
			LOG.info("geometry : {}", geometry.toString());
			return existePuntoEnShape(ubicacionUnidad, geometry.getCoordinates().get(0));
		} catch (Exception e) {
			LOG.error("Error al buscar alcaldia de unidad : {}", e);
			return false;
		}
	}

	/**
	 * Metodo para validar busqueda de un punto dentro de la zona de la alcaldia
	 * 
	 * @param puntoBusqueda
	 * @param shapePuntos
	 * @return
	 */
	private static boolean existePuntoEnShape(String puntoBusqueda, List<List<Double>> listaShapePuntos) {

		Path2D path = new Path2D.Double();

		List<Double> puntoShapeInicio = new ArrayList<>();
		boolean primerPunto = true;
		for (List<Double> shapePuntos : listaShapePuntos) {
			if (primerPunto) {
				puntoShapeInicio = shapePuntos;
				path.moveTo(shapePuntos.get(1), shapePuntos.get(0));
				primerPunto = false;
			} else {

				path.lineTo(shapePuntos.get(1), shapePuntos.get(0));
			}

		}
		// Cerramos la figura geométrica en caso los puntos proporcionados no lo hagan.
		path.closePath();
		// Verificamos si las coordenadas están dentro con el método contains
		boolean resultado = path.contains(puntoShapeInicio.get(1), puntoShapeInicio.get(0));
		LOG.info("existePuntoEnShape resultado : {}", resultado);
		LOG.info("existePuntoEnShape resultado2 test : {}", path.contains(-98.99706316999995, 19.226423519999157));
		return true;
	}

}
