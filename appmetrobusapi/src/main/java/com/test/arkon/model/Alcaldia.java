package com.test.arkon.model;

import javax.persistence.*;

@Entity
@Table(name = "t_registro_alcaldia")
public class Alcaldia {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "nomgeo")
	private String nombre;

	@Column(name = "cve_mun")
	private long cve_municipio;

	@Column(name = "cve_ent")
	private long cve_entidad;

	@Column(name = "cvegeo")
	private long cve_geografica;

	@Column(name = "geo_point_2d")
	private String geolocalizacion2d;

	@Column(name = "geo_shape")
	private String geolocalizacionShape;

	@Column(name = "municipio")
	private long idMunicipio;

	@Column(name = "estatus")
	private long estatus;

	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public long getCve_municipio() {
		return cve_municipio;
	}



	public void setCve_municipio(long cve_municipio) {
		this.cve_municipio = cve_municipio;
	}



	public long getCve_entidad() {
		return cve_entidad;
	}



	public void setCve_entidad(long cve_entidad) {
		this.cve_entidad = cve_entidad;
	}



	public long getCve_geografica() {
		return cve_geografica;
	}



	public void setCve_geografica(long cve_geografica) {
		this.cve_geografica = cve_geografica;
	}



	public String getGeolocalizacion2d() {
		return geolocalizacion2d;
	}



	public void setGeolocalizacion2d(String geolocalizacion2d) {
		this.geolocalizacion2d = geolocalizacion2d;
	}



	public String getGeolocalizacionShape() {
		return geolocalizacionShape;
	}



	public void setGeolocalizacionShape(String geolocalizacionShape) {
		this.geolocalizacionShape = geolocalizacionShape;
	}



	public long getIdMunicipio() {
		return idMunicipio;
	}



	public void setIdMunicipio(long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}



	public long getEstatus() {
		return estatus;
	}



	public void setEstatus(long estatus) {
		this.estatus = estatus;
	}



	@Override
	public String toString() {
		return "Alcaldia [id=" + id + ", nombre=" + nombre + ", cve_municipio=" + cve_municipio + ", cve_entidad="
				+ cve_entidad + ", cve_geografica=" + cve_geografica + ", geolocalizacion2d=" + geolocalizacion2d
				+ ", geolocalizacionShape=" + geolocalizacionShape + ", idMunicipio=" + idMunicipio + ", estatus="
				+ estatus + "]";
	}

}
