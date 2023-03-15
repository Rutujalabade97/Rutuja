package com.cg.apartment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.apartment.entities.VehicleEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.repository.VehicleDAOInt;

@Service
public class VehicleServiceImpl implements VehicleServiceInt
{
	@Autowired
	VehicleDAOInt vehdao;

	@Override
	public VehicleEntity addVehicle(VehicleEntity entity) throws DuplicateRecordException {
		Optional<VehicleEntity>vehicle=vehdao.findById(entity.getId());
		if(vehicle.isPresent()) {
			
			throw new DuplicateRecordException("Record already exist");
			
		}else {
			VehicleEntity newvehicle=vehdao.save(entity);
			return newvehicle;
		}
	}
	

	@Override
	public VehicleEntity update(VehicleEntity entity) {
		Optional<VehicleEntity>vehicle=vehdao.findById(entity.getId());
		if(vehicle.isPresent()) {
			VehicleEntity ve=vehicle.get();

			ve.setId(entity.getId());
			
			ve.setName(entity.getName());
			ve.setParkingNo(entity.getParkingNo());
			ve.setArrivalTime(entity.getArrivalTime());
			ve.setDepartureTime(entity.getDepartureTime());
			ve.setLocaldate(entity.getLocaldate());
			ve.setVehicleNo(entity.getVehicleNo());
			ve.setVehicleNo(entity.getVehicleNo());



			VehicleEntity update=vehdao.save(ve);

			return update;
		}else {

			VehicleEntity newVehicle=vehdao.save(entity);
			return newVehicle;

		}



	}


	@Override
	public String delete(Long id) throws RecordNotFoundException {
		Optional<VehicleEntity>vehicle=vehdao.findById(id);
		if(vehicle.isPresent()) {
			vehdao.deleteById(id);
			return "Successfully Deleted";
		}else {throw new RecordNotFoundException("Enter the correct id");

		}
	}

	

	@Override
	public VehicleEntity findByName(String name) throws RecordNotFoundException {
		if(name.matches(name)) {
			VehicleEntity vehicle=vehdao.findByName(name);
		return vehicle;
	}else
		throw new RecordNotFoundException("Record not found");
		
	}
	

	@Override
	public VehicleEntity findByPk(long id) throws RecordNotFoundException {
		Optional<VehicleEntity>vehicle=vehdao.findById(id);
		if(!vehicle.isPresent()) {throw new RecordNotFoundException("Record Not Found");}
		else {
			return vehicle.get();
		}

	}

	@Override
	public Page<VehicleEntity> search(VehicleEntity entity, long pageNo, int pageSize) {
		PageRequest firstPagesWithTwoElements = PageRequest.of(0,2,Sort.by("name"));
		Page<VehicleEntity> vehicle=vehdao.findAll(firstPagesWithTwoElements);
		return vehicle;
	}
	
	@Override
	public List<VehicleEntity> search(VehicleEntity entity) {
		List<VehicleEntity> searching =vehdao.findAll();
		return searching;
	}

}
