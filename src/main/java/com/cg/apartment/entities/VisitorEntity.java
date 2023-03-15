package com.cg.apartment.entities;

import java.sql.Date;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class VisitorEntity extends BaseEntity 
{
	private String name;
	@NotNull(message ="ownername is must")
	private String ownerName;
	@NotNull(message ="flatNo is must")
	private String flatNo;
	@NotNull(message ="date is must")
	private Date date;
	@NotNull(message ="arrivaltime is must")
	private String arrivalTime;
	@NotNull(message ="departuretime is must")
	private String departureTime;
	public VisitorEntity() {
		super();
	}
	public VisitorEntity(String name, String ownerName, String flatNo, Date date, String arrivalTime,
			String departureTime) {
		super();
		this.name = name;
		this.ownerName = ownerName;
		this.flatNo = flatNo;
		this.date = date;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	
	//Getters and Setters

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	@Override
	public String toString() {
		return "VisitorEntity [name=" + name + ", ownerName=" + ownerName + ", flatNo=" + flatNo + ", date=" + date
				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}



}
