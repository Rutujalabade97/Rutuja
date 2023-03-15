package com.cg.apartment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.apartment.entities.GardSalaryEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;

public interface GardSalaryServiceInt {
	
	public GardSalaryEntity add(GardSalaryEntity bean) throws DuplicateRecordException;

	public GardSalaryEntity update(GardSalaryEntity bean);

	public String delete(long id ) throws RecordNotFoundException;
	
	public GardSalaryEntity findByPk(long id);

	public Page<GardSalaryEntity> search(GardSalaryEntity bean, long pageNo, int pageSize);

	public List<GardSalaryEntity> search(GardSalaryEntity bean);
	
	public List<GardSalaryEntity> getSalaryList();


}
