package com.test.arkon.util.enums;

public enum EstatusProceso {

	CORRECTO(1, "CORRECTO"), INCORRECTO(2, "INCORRECTO");

	private int id;
	private String descripcion;

	private EstatusProceso(int id, String descripcion) {

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
