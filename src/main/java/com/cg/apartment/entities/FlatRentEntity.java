package com.cg.apartment.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity

public class FlatRentEntity extends BaseEntity
{

	@OneToOne  
	private FlatEntity flat;  

	public FlatEntity getFlat() {
		return flat;
	}
	public void setFlat(FlatEntity flat) {
		this.flat = flat;
	}
	public FlatRentEntity(FlatEntity flat, String ownerName, String flatNo, String amount, String type) {
		super();
		this.flat = flat;
		this.ownerName = ownerName;
		this.flatNo = flatNo;
		this.amount = amount;
		this.type = type;
	}
	private String ownerName;
	@NotNull(message="flatno should not be null")
	private String flatNo;
	@NotNull(message="amount should not be null")
	private String amount;
	private String type;
	public FlatRentEntity(String ownerName, String flatNo, String amount, String type) {
		super();
		this.ownerName = ownerName;
		this.flatNo = flatNo;
		this.amount = amount;
		this.type = type;
	}
	public FlatRentEntity() {
		super();
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "FlatRentEntity [flat=" + flat + ", ownerName=" + ownerName + ", flatNo=" + flatNo + ", amount=" + amount
				+ ", type=" + type + "]";
	}




}
