package com.cg.apartment.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity

public class DeliveryEntity extends BaseEntity
{ 
	
	private String ownerName;
	
	private String time;
	@NotNull(message="date should not be null")
	
	private Date date;
	@NotNull(message="status should not be null")
	
	private String status;
	
	public DeliveryEntity() {
		super();
	}
	public DeliveryEntity(String ownerName, String time, Date date, String status) {
		super();
		this.ownerName = ownerName;
		this.time = time;
		this.date = date;
		this.status = status;
	}
	
	//Getters and Setters

	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Delivery [ownerName=" + ownerName + ", time=" + time + ", date=" + date + ", status=" + status + "]";
	}



}
