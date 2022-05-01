package com.test.arkon.util;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.arkon.model.Geometry;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;

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

		final GeometryFactory gf = new GeometryFactory();
		final ArrayList<Coordinate> shapePoints = new ArrayList<Coordinate>();

		for (List<Double> shapePuntos : listaShapePuntos) {
			shapePoints.add(new Coordinate(shapePuntos.get(1), shapePuntos.get(0)));

		}
		final Polygon polygon = gf.createPolygon(new LinearRing(
				new CoordinateArraySequence(shapePoints.toArray(new Coordinate[shapePoints.size()])), gf), null);

		String[] splitCordenadaBusqueda = puntoBusqueda.split(COMA);
		double puntoA = Double.parseDouble(splitCordenadaBusqueda[0]);
		double puntoB = Double.parseDouble(splitCordenadaBusqueda[1]);
		final Coordinate coord = new Coordinate(puntoA, puntoB);
		final Point pointBusqueda = gf.createPoint(coord);
		LOG.info("existePuntoEnShape puntoBusqueda : {}", puntoBusqueda);
		boolean resultado= pointBusqueda.within(polygon);
		LOG.info("existePuntoEnShape polygon : {}", polygon);
		LOG.info("existePuntoEnShape resultado : {}", resultado);
		
		final Coordinate coordTest = new Coordinate( 19.226423519999157, -98.99706316999995);
		final Point pointBusquedaTest = gf.createPoint(coordTest);
		LOG.info("existePuntoEnShape resultado2 test : {}", pointBusquedaTest.within(polygon));
		return resultado;
	}

}
