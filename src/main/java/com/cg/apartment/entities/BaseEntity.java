package com.cg.apartment.entities;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseEntity implements DropDropList 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	protected long id;


	public BaseEntity() {
		super();
	}

	public BaseEntity(long id) {
		super();
		this.id = id;
	}

     //Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "BaseEntity [id=" + id + "]";
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
