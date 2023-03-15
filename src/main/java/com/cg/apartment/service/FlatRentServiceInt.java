package com.cg.apartment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.apartment.entities.FlatRentEntity;
import com.cg.apartment.exception.RecordNotFoundException;

public interface FlatRentServiceInt 
{
public long add(FlatRentEntity bean);
	
	public  FlatRentEntity update(FlatRentEntity bean);
	
	String delete(Long id) throws RecordNotFoundException;
	
	public FlatRentEntity findByName(String ownerName);
	
	public FlatRentEntity findByPk(long id) throws RecordNotFoundException;
	
	public Page<FlatRentEntity> search(FlatRentEntity bean, long pageNo, int pageSize);
	
	public List<FlatRentEntity> search(FlatRentEntity bean);
	
	public List<FlatRentEntity> getFlatRentEntityList();
	

	

}
