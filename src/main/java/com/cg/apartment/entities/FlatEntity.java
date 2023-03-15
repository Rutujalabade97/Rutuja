package com.cg.apartment.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.tool.hbm2ddl.Target;

@Entity

public class FlatEntity extends BaseEntity
{
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	
	private List <VisitorEntity> visitor=new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  
	
	private List <DeliveryEntity> delivery = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true) 
	
	private List <DomesticHelpEntity> domestichelp = new ArrayList<>();


	private String ownerName;
	@NotNull(message="flatno should not be null")
	private String flatNo;
	@NotNull(message="floorno should not be null")
	private String floorNo;
	private String flatType;



	public FlatEntity(String ownerName, String flatNo, String floorNo, String flatType) {
		super();
		this.ownerName = ownerName;
		this.flatNo = flatNo;
		this.floorNo = floorNo;
		this.flatType = flatType;
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

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public String getFlatType() {
		return flatType;
	}

	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}




	public FlatEntity() {
		super();
	}

	public List<VisitorEntity> getVisitor() {
		return visitor;
	}

	public void setVisitor(List<VisitorEntity> visitor) {
		this.visitor = visitor;
	}

	public List<DeliveryEntity> getDelivery() {
		return delivery;
	}

	public void setDelivery(List<DeliveryEntity> delivery) {
		this.delivery = delivery;
	}

	public List<DomesticHelpEntity> getDomestichelp() {
		return domestichelp;
	}

	public void setDomestichelp(List<DomesticHelpEntity> domestichelp) {
		this.domestichelp = domestichelp;
	}

	public FlatEntity(List<VisitorEntity> visitor, List<DeliveryEntity> delivery, List<DomesticHelpEntity> domestichelp,
			String ownerName, String floorNo, String flatType) {
		super();
		this.visitor = visitor;
		this.delivery = delivery;
		this.domestichelp = domestichelp;
		this.ownerName = ownerName;
		this.floorNo = floorNo;
		this.flatType = flatType;
	}


	@Override
	public String toString() {
		return "FlatEntity [visitor=" + visitor + ", delivery=" + delivery + ", domestichelp=" + domestichelp
				+ ", ownerName=" + ownerName + ", floorNo=" + floorNo + ", flatType=" + flatType + "]";
	}



}