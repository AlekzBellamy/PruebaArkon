package com.test.arkon.util.enums;

/**
 * catalogo de resultados
 * @author nodez
 *
 */
public enum ResultadoCodigo {

	CORRECTO(1, "Resultado Correcto"), 
	INCORRECTO_BD(2, "Ocurrió un error al consultar la información, favor intentar de nuevo"),
	INCORRECTO_PROCESO(3, "Ocurrió un error al procesar la información, favor intentar de nuevo");

	private int id;
	private String descripcion;

	private ResultadoCodigo(int id, String descripcion) {

		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
