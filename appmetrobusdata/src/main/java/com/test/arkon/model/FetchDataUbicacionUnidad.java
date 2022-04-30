package com.test.arkon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fetchdata_unidades_mb")
public class FetchDataUbicacionUnidad {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_fetch")
	private long id_fetch;
	
	@Column(name = "fecha_registro")
	private Date fecha_registro;
	
	@Column(name = "estatus_proceso")
	private String estatus_proceso;

	public long getId_fetch() {
		return id_fetch;
	}

	public void setId_fetch(long id_fetch) {
		this.id_fetch = id_fetch;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getEstatus_proceso() {
		return estatus_proceso;
	}

	public void setEstatus_proceso(String estatus_proceso) {
		this.estatus_proceso = estatus_proceso;
	}
	
	
}
