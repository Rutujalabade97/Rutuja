package com.cg.apartment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.apartment.entities.DomesticHelpEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;

public interface DomesticHelpServiceInt 
{
	public DomesticHelpEntity addDomestic(DomesticHelpEntity entity) throws DuplicateRecordException;

	public DomesticHelpEntity update(DomesticHelpEntity  entity);

	String delete(long id) throws RecordNotFoundException;

	DomesticHelpEntity findByName(String name) throws RecordNotFoundException;

	public DomesticHelpEntity findByPk(long id) throws RecordNotFoundException;

	public Page<DomesticHelpEntity> search(DomesticHelpEntity  entity, long pageNo, int pageSize);

	public List<DomesticHelpEntity> search(DomesticHelpEntity  entity);




}
