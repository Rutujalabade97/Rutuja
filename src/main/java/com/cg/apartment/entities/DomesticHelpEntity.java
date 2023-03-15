package com.cg.apartment.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity

public class DomesticHelpEntity extends BaseEntity
{
	@NotNull(message="flatno should not be null")
	private String flatNo;

	@NotNull(message ="ownername is must")
	private String ownerName;

	private String name;

	private String helpType;

	@NotNull(message ="arrivaltime is must")

	private String arrivalTime;

	@NotNull(message ="departuretime is must")

	private String departureTime;

	@NotNull(message="date should not be null")
	@Column(name="localdate")
	
	private  LocalDate Localdate;

	public DomesticHelpEntity() {
		super();
	}

	public DomesticHelpEntity(String flatNo, String ownerName, String name, String helpType, String arrivalTime,
			String departureTime, String date, LocalDate localdate) {
		super();
		this.flatNo = flatNo;
		this.ownerName = ownerName;
		this.name = name;
		this.helpType = helpType;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;

		Localdate = localdate;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHelpType() {
		return helpType;
	}

	public void setHelpType(String helpType) {
		this.helpType = helpType;
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


	public LocalDate getLocaldate() {
		return Localdate;
	}

	public void setLocaldate(LocalDate localdate) {
		Localdate = localdate;
	}

	@Override
	public String toString() {
		return "DomesticHelpEntity [flatNo=" + flatNo + ", ownerName=" + ownerName + ", name=" + name + ", helpType="
				+ helpType + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", Localdate="
				+ Localdate + "]";
	}



}
