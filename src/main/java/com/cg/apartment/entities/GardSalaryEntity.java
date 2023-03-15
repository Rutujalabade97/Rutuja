package com.cg.apartment.entities;

import java.sql.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity

public class GardSalaryEntity extends BaseEntity
{
	

	private String name;
	
	@NotNull(message =" userid cannot be null")
	private long userId;
	@NotNull(message="amount should not be null")
	private long amount;
	@NotNull(message="status should not be null")
	private String status;
	@NotNull(message="date should not be null")
	private Date date;
	
	
	
	public GardSalaryEntity() {
		super();
	}
	public GardSalaryEntity(String name, @NotNull(message = " userid cannot be null") long userId, long amount, String status, Date date) {
		super();
		this.name = name;
		this.userId = userId;
		this.amount = amount;
		this.status = status;
		this.date = date;
	}
	
	//Getters and Setters

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(@NotNull(message = " userid cannot be null") long userId) {
		this.userId = userId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "GardSalaryEntity [name=" + name + ", userId=" + userId + ", amount=" + amount + ", status=" + status
				+ ", date=" + date + "]";
	}
	
}
