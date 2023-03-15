package com.cg.apartment.service;


import java.util.List;


import com.cg.apartment.entities.GardShiftEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;



public interface GardShiftServiceInt 
{
	public GardShiftEntity add(GardShiftEntity object) throws DuplicateRecordException;

	public GardShiftEntity update(GardShiftEntity objectt);

	public String delete(long object) throws RecordNotFoundException;

	public GardShiftEntity findByName(String name);

	public GardShiftEntity findByPk(long id);

	public List<GardShiftEntity> search(GardShiftEntity object, long pageNo, int pageSize);

	public List<GardShiftEntity> search(GardShiftEntity obejct);


}
