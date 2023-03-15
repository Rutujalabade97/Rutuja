package com.cg.apartment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.apartment.entities.SecurityEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;

public interface SecurityServiceInt {

	public SecurityEntity addSecurity(SecurityEntity bean) throws DuplicateRecordException;
	
	public SecurityEntity update(SecurityEntity bean);
	
	String delete(Long id) throws RecordNotFoundException;
	
	public SecurityEntity findByPk(long id) throws RecordNotFoundException;
	
	public Page<SecurityEntity> searchByPage(SecurityEntity bean, long pageNo, int pageSize);
	
	public List<SecurityEntity> search(SecurityEntity bean);

	SecurityEntity findByName(String message) throws RecordNotFoundException;

}
