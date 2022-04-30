package com.test.arkon.util.enums;

public enum Estatus {

	ACTIVO(1, "ACTIVO"), INACTIVO(2, "INACTIVO");

	private int id;
	private String descripcion;

	private Estatus(int id, String descripcion) {

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
