package com.test.arkon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_registro_mb")
public class DataMbCdmxUnidadUbicacion {

	@Id
	@GeneratedValue
	private long _id;

	@Column(name = "id")
	private long id;

	@Column(name = "date_updated")
	private Date date_updated;

	@Column(name = "vehicle_id")
	private long vehicle_id;

	@Column(name = "vehicle_label")
	private long vehicle_label;

	@Column(name = "vehicle_current_status")
	private long vehicle_current_status;

	@Column(name = "position_latitude")
	private String position_latitude;

	@Column(name = "position_longitude")
	private String position_longitude;

	@Column(name = "geographic_point")
	private String geographic_point;

	@Column(name = "position_speed")
	private String position_speed;

	@Column(name = "position_odometer")
	private String position_odometer;

	@Column(name = "trip_schedule_relationship")
	private String trip_schedule_relationship;

	@Column(name = "trip_id")
	private String trip_id;

	@Column(name = "trip_start_date")
	private String trip_start_date;

	@Column(name = "trip_route_id")
	private String trip_route_id;

	@Column(name = "id_fetch_mb")
	private long id_fetch_mb;

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

	public Date getDate_updated() {
		return date_updated;
	}

	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}

	public long getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public long getVehicle_label() {
		return vehicle_label;
	}

	public void setVehicle_label(long vehicle_label) {
		this.vehicle_label = vehicle_label;
	}

	public long getVehicle_current_status() {
		return vehicle_current_status;
	}

	public void setVehicle_current_status(long vehicle_current_status) {
		this.vehicle_current_status = vehicle_current_status;
	}

	public String getPosition_latitude() {
		return position_latitude;
	}

	public void setPosition_latitude(String position_latitude) {
		this.position_latitude = position_latitude;
	}

	public String getPosition_longitude() {
		return position_longitude;
	}

	public void setPosition_longitude(String position_longitude) {
		this.position_longitude = position_longitude;
	}

	public String getGeographic_point() {
		return geographic_point;
	}

	public void setGeographic_point(String geographic_point) {
		this.geographic_point = geographic_point;
	}

	public String getPosition_speed() {
		return position_speed;
	}

	public void setPosition_speed(String position_speed) {
		this.position_speed = position_speed;
	}

	public String getPosition_odometer() {
		return position_odometer;
	}

	public void setPosition_odometer(String position_odometer) {
		this.position_odometer = position_odometer;
	}

	public String getTrip_schedule_relationship() {
		return trip_schedule_relationship;
	}

	public void setTrip_schedule_relationship(String trip_schedule_relationship) {
		this.trip_schedule_relationship = trip_schedule_relationship;
	}

	public String getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}

	public String getTrip_start_date() {
		return trip_start_date;
	}

	public void setTrip_start_date(String trip_start_date) {
		this.trip_start_date = trip_start_date;
	}

	public String getTrip_route_id() {
		return trip_route_id;
	}

	public void setTrip_route_id(String trip_route_id) {
		this.trip_route_id = trip_route_id;
	}

	public long getId_fetch_mb() {
		return id_fetch_mb;
	}

	public void setId_fetch_mb(long id_fetch_mb) {
		this.id_fetch_mb = id_fetch_mb;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "DataMbCdmxUnidadUbicacion [_id=" + _id + ", id=" + id + ", date_updated=" + date_updated
				+ ", vehicle_id=" + vehicle_id + ", vehicle_label=" + vehicle_label + ", vehicle_current_status="
				+ vehicle_current_status + ", position_latitude=" + position_latitude + ", position_longitude="
				+ position_longitude + ", geographic_point=" + geographic_point + ", position_speed=" + position_speed
				+ ", position_odometer=" + position_odometer + ", trip_schedule_relationship="
				+ trip_schedule_relationship + ", trip_id=" + trip_id + ", trip_start_date=" + trip_start_date
				+ ", trip_route_id=" + trip_route_id + ", id_fetch_mb=" + id_fetch_mb + ", estatus=" + estatus + "]";
	}

}
