package com.cg.apartment.service;

import java.util.List;

import com.cg.apartment.entities.GardSalaryEntity;
import com.cg.apartment.entities.GardTrainingEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;

public interface GardTrainingServiceInt 
{
public GardTrainingEntity add(GardTrainingEntity entity) throws DuplicateRecordException;
	
	public GardTrainingEntity update(GardTrainingEntity entity);
	
	public String delete(long id) throws RecordNotFoundException;
	
	public GardTrainingEntity findByName(String name);
	
	public GardTrainingEntity findByPk(long id);
	
	public List<GardTrainingEntity> search(GardTrainingEntity entity, long pageNo, int pageSize);
	
	public List<GardTrainingEntity> search(GardTrainingEntity entity);
	public List<GardTrainingEntity> gettrainingList();
}
