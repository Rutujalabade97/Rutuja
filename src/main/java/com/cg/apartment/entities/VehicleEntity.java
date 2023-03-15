package com.cg.apartment.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class VehicleEntity extends BaseEntity
{
	private String name;
	@NotNull(message ="parkingNo is must")
	private String parkingNo;
	@NotNull(message ="arrivaltime is must")
	private String arrivalTime;
	@NotNull(message ="departuretime is must")
	private String departureTime;
	@NotNull(message ="VehicleNo is must")
	private String vehicleNo;
	@NotNull(message ="Vehicletype is must")
	private String vehicleType;
	@Column(name="date")
	@NotNull(message ="Localdate is must")

	private LocalDate Localdate;
	public VehicleEntity() {
		super();
	}
	public VehicleEntity(String name, String parkingNo, String arrivalTime, String departureTime, Date date,
			String vehicleNo, String vehicleType, LocalDate localdate) {
		super();
		this.name = name;
		this.parkingNo = parkingNo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
		Localdate = localdate;
	}
	
	//Getters and Setters

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParkingNo() {
		return parkingNo;
	}
	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public LocalDate getLocaldate() {
		return Localdate;
	}
	public void setLocaldate(LocalDate localdate) {
		Localdate = localdate;
	}
	@Override
	public String toString() {
		return "VehicleEntity [name=" + name + ", parkingNo=" + parkingNo + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", vehicleNo=" + vehicleNo + ", vehicleType=" + vehicleType
				+ ", Localdate=" + Localdate + "]";
	}
	


}
