package com.test.arkon.model;

import com.test.arkon.util.enums.ResultadoCodigo;

public class Respuesta<T> {

	private int codigo;
	private String descripcion;
	private T resultado;

	public Respuesta() {
		this.codigo = ResultadoCodigo.CORRECTO.getId();
		this.descripcion = ResultadoCodigo.CORRECTO.getDescripcion();
	}

	public Respuesta(int codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public T getResultado() {
		return resultado;
	}

	public void setResultado(T resultado) {
		this.resultado = resultado;
	}

}
