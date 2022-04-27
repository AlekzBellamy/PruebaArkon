package com.test.arkon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_registro_mb")
public class UbicacionUnidad {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "date_updated")
	private Date fecha_actualizacion;

	@Column(name = "vehicle_id")
	private long idVehiculo;

	@Column(name = "vehicle_label")
	private long labelVehiculo;

	@Column(name = "vehicle_current_status")
	private long estadoActualVehiculo;

	@Column(name = "position_latitude")
	private String positionLatitude;

	@Column(name = "position_longitude")
	private String positionLongitude;

	@Column(name = "geographic_point")
	private String geolocalizacionPoint;

	@Column(name = "position_speed")
	private long positionSpeed;

	@Column(name = "position_odometer")
	private long positionOdometer;

	@Column(name = "trip_schedule_relationship")
	private long scheduleRelationshipTrip;

	@Column(name = "trip_id")
	private String idTrip;

	@Column(name = "trip_start_date")
	private String startDateTrip;

	@Column(name = "trip_route_id")
	private String idRouteTrip;

	@Column(name = "estatus")
	private long estatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_actualizacion() {
		return fecha_actualizacion;
	}

	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public long getLabelVehiculo() {
		return labelVehiculo;
	}

	public void setLabelVehiculo(long labelVehiculo) {
		this.labelVehiculo = labelVehiculo;
	}

	public long getEstadoActualVehiculo() {
		return estadoActualVehiculo;
	}

	public void setEstadoActualVehiculo(long estadoActualVehiculo) {
		this.estadoActualVehiculo = estadoActualVehiculo;
	}

	public String getPositionLatitude() {
		return positionLatitude;
	}

	public void setPositionLatitude(String positionLatitude) {
		this.positionLatitude = positionLatitude;
	}

	public String getPositionLongitude() {
		return positionLongitude;
	}

	public void setPositionLongitude(String positionLongitude) {
		this.positionLongitude = positionLongitude;
	}

	public String getGeolocalizacionPoint() {
		return geolocalizacionPoint;
	}

	public void setGeolocalizacionPoint(String geolocalizacionPoint) {
		this.geolocalizacionPoint = geolocalizacionPoint;
	}

	public long getPositionSpeed() {
		return positionSpeed;
	}

	public void setPositionSpeed(long positionSpeed) {
		this.positionSpeed = positionSpeed;
	}

	public long getPositionOdometer() {
		return positionOdometer;
	}

	public void setPositionOdometer(long positionOdometer) {
		this.positionOdometer = positionOdometer;
	}

	public long getScheduleRelationshipTrip() {
		return scheduleRelationshipTrip;
	}

	public void setScheduleRelationshipTrip(long scheduleRelationshipTrip) {
		this.scheduleRelationshipTrip = scheduleRelationshipTrip;
	}

	public String getIdTrip() {
		return idTrip;
	}

	public void setIdTrip(String idTrip) {
		this.idTrip = idTrip;
	}

	public String getStartDateTrip() {
		return startDateTrip;
	}

	public void setStartDateTrip(String startDateTrip) {
		this.startDateTrip = startDateTrip;
	}

	public String getIdRouteTrip() {
		return idRouteTrip;
	}

	public void setIdRouteTrip(String idRouteTrip) {
		this.idRouteTrip = idRouteTrip;
	}

	public long getEstatus() {
		return estatus;
	}

	public void setEstatus(long estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "UbicacionUnidad [id=" + id + ", fecha_actualizacion=" + fecha_actualizacion + ", idVehiculo="
				+ idVehiculo + ", labelVehiculo=" + labelVehiculo + ", estadoActualVehiculo=" + estadoActualVehiculo
				+ ", positionLatitude=" + positionLatitude + ", positionLongitude=" + positionLongitude
				+ ", geolocalizacionPoint=" + geolocalizacionPoint + ", positionSpeed=" + positionSpeed
				+ ", positionOdometer=" + positionOdometer + ", scheduleRelationshipTrip=" + scheduleRelationshipTrip
				+ ", idTrip=" + idTrip + ", startDateTrip=" + startDateTrip + ", idRouteTrip=" + idRouteTrip
				+ ", estatus=" + estatus + "]";
	}

}
