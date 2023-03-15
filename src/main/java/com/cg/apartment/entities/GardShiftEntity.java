package com.cg.apartment.entities;

import java.sql.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
@Entity

public class GardShiftEntity  extends BaseEntity
{
  
	@NotNull(message =" userid cannot be null")
	private long userId;
	private String name;
	private String time;
	@NotNull(message ="date cannot be null")
	private Date date;
	
	
	
	
	
	public GardShiftEntity(long userId, String name, String time, Date date) {
		super();
		this.userId = userId;
		this.name = name;
		this.time = time;
		this.date = date;
	}
	public GardShiftEntity() {
		super();
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
	@Override
	public String toString() {
		return "GardShiftEntity [userId=" + userId + ", name=" + name + ", time=" + time + ", date=" + date + "]";
	}
	


}
