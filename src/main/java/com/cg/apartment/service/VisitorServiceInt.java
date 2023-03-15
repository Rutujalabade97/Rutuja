package com.cg.apartment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.apartment.entities.VehicleEntity;
import com.cg.apartment.entities.VisitorEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;

public interface VisitorServiceInt 
{
	public long add(VisitorEntity bean);

	public VisitorEntity update(VisitorEntity bean);
	
	public String delete(Long id) throws RecordNotFoundException;
	
	public VisitorEntity findByName(String name) throws RecordNotFoundException;
	
	public List<VisitorEntity> search(VisitorEntity bean);

	public List<VisitorEntity> getVisitorEntityList();

	public VisitorEntity findByPk(long id) throws RecordNotFoundException;

	public Page<VisitorEntity> search(VisitorEntity entity, long pageNo, int pageSize);
	
	

}
