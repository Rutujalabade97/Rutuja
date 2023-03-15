package com.cg.apartment.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.GardSalaryEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.repository.GardSalaryDAOInt;




@Service

public class GardSalaryImpl implements GardSalaryServiceInt{

	
	@Autowired
	GardSalaryDAOInt salrepo;

	@Override
	public GardSalaryEntity add(GardSalaryEntity bean) throws DuplicateRecordException {
		Optional<GardSalaryEntity> security=salrepo.findById(bean.getId());
		if(security.isPresent()) {
			
			throw new DuplicateRecordException("Record already exist");
			
		}else {
	
			GardSalaryEntity se= security.get();
			se.setId(bean.getId());
			
			se.setAmount(bean.getAmount());
			se.setName(bean.getName());
			se.setUserId(bean.getUserId());
			se.setStatus(bean.getStatus());
			se.setDate(bean.getDate());
			
			GardSalaryEntity add= salrepo.save(se);
			
			return add;
		}
		
	}
			
		
	

	@Override
	public GardSalaryEntity update(GardSalaryEntity bean) {
		Optional<GardSalaryEntity> salary1=salrepo.findById(bean.getId());
		if(salary1.isPresent())
		{
			GardSalaryEntity salary2=salary1.get();
			salary2.getUserId();
			salary2.getName();
			salary2.getAmount();
			salary2.getStatus();
			salary2.getDate();
			
			
		GardSalaryEntity added= salrepo.save(salary2);
			return added;
		}
		else
		{
		 GardSalaryEntity entity= salrepo.save(bean);
		 return entity;
		}

		
	}
	
		
	
	

		

	@Override
	public GardSalaryEntity findByPk(long id) {
		Optional<GardSalaryEntity> salary=salrepo.findById(id);
		if(!salary.isPresent())
			throw new NoSuchElementException("not found");
		else
			return salary.get();
		
		
	}

	
	@Override
	
		public Page<GardSalaryEntity> search(GardSalaryEntity entity, long pageNo, int pageSize)
		{
			PageRequest firstPageWithTwoElements = PageRequest.of(0, 2,Sort.by("name"));
			Page<GardSalaryEntity> e=salrepo.findAll(firstPageWithTwoElements);
			return e;
		}

	@Override
	public List<GardSalaryEntity> search(GardSalaryEntity bean) {
		List<GardSalaryEntity> searching= salrepo.findAll();
		return searching;
		}

	@Override
	public List<GardSalaryEntity> getSalaryList() {
	
		return salrepo.findAll();
	}

	@Override
	public String delete(long id) throws RecordNotFoundException {
		Optional<GardSalaryEntity> salary=salrepo.findById(id);
		if(salary.isPresent()) {
			salrepo.deleteById(id);
			return "Successfully deleted";
		}
		else {
				throw new RecordNotFoundException("Enter the correct id");
			}
		}
	}
	
	



