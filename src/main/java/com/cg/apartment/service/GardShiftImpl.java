package com.cg.apartment.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.GardShiftEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.repository.GardShiftIDAOInt;

@Service
public class GardShiftImpl implements GardShiftServiceInt {
	
	@Autowired
	GardShiftIDAOInt shiftrepo;

	@Override
	public GardShiftEntity add(GardShiftEntity object) throws DuplicateRecordException {
		Optional<GardShiftEntity> shift=shiftrepo.findById(object.getId());
		if(shift.isPresent()) {
			
			throw new DuplicateRecordException("Record already exist");
			
		}else {
	
			GardShiftEntity se= shift.get();
			se.setId(object.getId());
			se.setName(object.getName());
			se.setUserId(object.getUserId());
			se.setTime(object.getTime());
			se.setDate(object.getDate());
			
			GardShiftEntity add= shiftrepo.save(se);
			
			return add;
		}
		
	}
	@Override
	public GardShiftEntity update(GardShiftEntity objectt) {
		Optional<GardShiftEntity> shift1=shiftrepo.findById(objectt.getId());
		if(shift1.isPresent())
		{
			GardShiftEntity shift2=shift1.get();
			shift2.getUserId();
			shift2.getName();
			shift2.getTime();
			shift2.getDate();
			
			
		GardShiftEntity added= shiftrepo.save(shift2);
			return added;
		}
		else
		{
		 GardShiftEntity entity= shiftrepo.save(objectt);
		 return entity;
		}

		
		
	}

	@Override
	public String delete(long  object) throws RecordNotFoundException {
		Optional<GardShiftEntity> shift=shiftrepo.findById(object);
		if(shift.isPresent()) {
			shiftrepo.deleteById(object);
			return "Successfully deleted";
		}
		else {
				throw new RecordNotFoundException("Enter the correct id");
			}
		}
		

		
	

	@Override
	
	public GardShiftEntity findByName(String name) {
		GardShiftEntity delivery=shiftrepo.findByName(name);
		return delivery;
	}
	

	@Override
	public GardShiftEntity findByPk(long id) {
		Optional<GardShiftEntity> shift=shiftrepo.findById(id);
		if(!shift.isPresent())
			throw new NoSuchElementException("not found");
		else
			return shift.get();
		
	}

	
	@Override
	public List<GardShiftEntity> search(GardShiftEntity object, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GardShiftEntity> search(GardShiftEntity obejct) {
		List<GardShiftEntity> searching= shiftrepo.findAll();
		return searching;
	
	}

	
}
