package com.test.arkon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "t_registro_alcaldia")
public class DataMbCdmxAlcaldia {

	@Id
	@GeneratedValue
	private long _id;

	@Column(name = "id")
	private long id;

	@Column(name = "nomgeo")
	private String nomgeo;

	@Column(name = "cve_mun")
	private long cve_mun;

	@Column(name = "cve_ent")
	private long cve_ent;

	@Column(name = "cvegeo")
	private String cvegeo;

	@Column(name = "geo_point_2d")
	private String geo_point_2d;

	@Column(name = "geo_shape")
	private String geo_shape;

	@Column(name = "municipio")
	private long municipio;

	@Column(name = "id_fetch_alcaldia")
	private long id_fetch_alcaldia;

	@Column(name = "estatus")
	private int estatus;

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomgeo() {
		return nomgeo;
	}

	public void setNomgeo(String nomgeo) {
		this.nomgeo = nomgeo;
	}

	public long getCve_mun() {
		return cve_mun;
	}

	public void setCve_mun(long cve_mun) {
		this.cve_mun = cve_mun;
	}

	public long getCve_ent() {
		return cve_ent;
	}

	public void setCve_ent(long cve_ent) {
		this.cve_ent = cve_ent;
	}

	public String getCvegeo() {
		return cvegeo;
	}

	public void setCvegeo(String cvegeo) {
		this.cvegeo = cvegeo;
	}

	public String getGeo_point_2d() {
		return geo_point_2d;
	}

	public void setGeo_point_2d(String geo_point_2d) {
		this.geo_point_2d = geo_point_2d;
	}

	public String getGeo_shape() {
		return geo_shape;
	}

	public void setGeo_shape(String geo_shape) {
		this.geo_shape = geo_shape;
	}

	public long getMunicipio() {
		return municipio;
	}

	public void setMunicipio(long municipio) {
		this.municipio = municipio;
	}

	public long getId_fetch_alcaldia() {
		return id_fetch_alcaldia;
	}

	public void setId_fetch_alcaldia(long id_fetch_alcaldia) {
		this.id_fetch_alcaldia = id_fetch_alcaldia;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "DataMbCdmxAlcaldia [_id=" + _id + ", id=" + id + ", nomgeo=" + nomgeo + ", cve_mun=" + cve_mun
				+ ", cve_ent=" + cve_ent + ", cvegeo=" + cvegeo + ", geo_point_2d=" + geo_point_2d + ", geo_shape="
				+ geo_shape + ", municipio=" + municipio + ", id_fetch_alcaldia=" + id_fetch_alcaldia + ", estatus="
				+ estatus + "]";
	}

}
