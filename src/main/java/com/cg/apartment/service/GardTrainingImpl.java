package com.cg.apartment.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.GardTrainingEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.repository.GardTrainingDAOInt;

@Service
public class GardTrainingImpl implements GardTrainingServiceInt
{
	@Autowired
	GardTrainingDAOInt trainingrepo;


	@Override
	public GardTrainingEntity add(GardTrainingEntity entity) throws DuplicateRecordException {
		Optional<GardTrainingEntity> training=trainingrepo.findById(entity.getId());
		if(training.isPresent()) {
			
			throw new DuplicateRecordException("Record already exist");
			
		}else {
	
			GardTrainingEntity se= training.get();
			se.setId(entity.getId());
			
			se.setUserId(entity.getUserId());
			se.setName(entity.getName());
			se.setMobileNo(entity.getMobileNo());
			se.setStatus(entity.getStatus());
			se.setTimeing(entity.getTimeing());
			se.setDate(entity.getDate());
			GardTrainingEntity adding= trainingrepo.save(entity);
			
			return adding;
		}
		
	}
	@Override
	public GardTrainingEntity update(GardTrainingEntity entity) {
		Optional<GardTrainingEntity> trainupdate=trainingrepo.findById(entity.getId());
		if(trainupdate.isPresent())
		{
			GardTrainingEntity training=trainupdate.get();
			training.getUserId();
			training.getName();
			training.getMobileNo();
			training.getStatus();
			training.getTimeing();
			training.getDate();
			
			
		GardTrainingEntity trainingadded= trainingrepo.save(training);
			return trainingadded;
		}
		else
		{
		 GardTrainingEntity obj= trainingrepo.save(entity);
		 return obj;
		}
	}
	@Override
	
	public GardTrainingEntity findByName(String name) {
		GardTrainingEntity delivery=trainingrepo.findByName(name);
		return delivery;
	}
		
	@Override
	public GardTrainingEntity findByPk(long id) {
		Optional<GardTrainingEntity> training2=trainingrepo.findById(id);
		if(!training2.isPresent())
			throw new NoSuchElementException("not found");
		else
			return training2.get();
		
		
	}
		
	@Override
	public List<GardTrainingEntity> search(GardTrainingEntity entity, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GardTrainingEntity> search(GardTrainingEntity entity) {
		List<GardTrainingEntity> searching= trainingrepo.findAll();
		return searching;
		
	}
	@Override
	public String delete(long id) throws RecordNotFoundException {
		Optional<GardTrainingEntity> training1=trainingrepo.findById(id);
		if(training1.isPresent()) {
			trainingrepo.deleteById(id);
			return "Successfully deleted";
		}
		else {
				throw new RecordNotFoundException("Enter the correct id");
			}
		
	

		
	}
	@Override
	public List<GardTrainingEntity> gettrainingList() {
		return trainingrepo.findAll();
		
	}

	
	
}
