package com.cg.apartment.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class SecurityEntity extends BaseEntity 
{
	@NotNull(message ="message cannot be null")
	private String message;
	@NotNull(message =" alert cannot be null")
	private String alert;
	public SecurityEntity() {
		super();
	}
	
	//Getters and Setters

	public SecurityEntity(String message, String alert) {
		super();
		this.message = message;
		this.alert = alert;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	@Override
	public String toString() {
		return "SecurityEntity [message=" + message + ", alert=" + alert + "]";
	}



}
