package com.cg.apartment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.apartment.entities.FlatEntity;
import com.cg.apartment.entities.FlatRentEntity;
import com.cg.apartment.exception.RecordNotFoundException;

public interface FlatServiceInt
{
public FlatEntity add(FlatEntity bean);
	
	public FlatEntity update(FlatEntity bean);
	
	String delete(Long id) throws RecordNotFoundException;
	
	public FlatEntity findByName(String ownerName);
	
	public FlatEntity findByPk(long id) throws RecordNotFoundException ;
	
	
	
	public List<FlatEntity> search(FlatEntity bean);
	public List<FlatEntity> getFlatEntityList();
	
	public Page<FlatEntity> search(FlatEntity bean, long pageNo, int pageSize);


}
