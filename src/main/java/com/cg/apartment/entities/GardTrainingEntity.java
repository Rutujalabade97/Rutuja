package com.cg.apartment.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class GardTrainingEntity extends BaseEntity
{
	@NotNull(message =" userid cannot be null")
	private long userId;
	private String name;
	@NotNull(message =" mobileno cannot be null")
	private String mobileNo;
	@NotNull(message =" status cannot be null")
	private String status;
	private String timeing;
	@NotNull(message =" date cannot be null")
	private Date date;
	public GardTrainingEntity() {
		super();
	}
	public GardTrainingEntity(long userId, String name, String mobileNo, String status, String timeing, Date date) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.status = status;
		this.timeing = timeing;
		this.date = date;
	}
	
	//Getters and Setters

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimeing() {
		return timeing;
	}
	public void setTimeing(String timeing) {
		this.timeing = timeing;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "GardTrainingEntity [userId=" + userId + ", name=" + name + ", mobileNo=" + mobileNo + ", status="
				+ status + ", timeing=" + timeing + ", date=" + date + "]";
	}

}
