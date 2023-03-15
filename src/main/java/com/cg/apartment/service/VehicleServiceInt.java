package com.cg.apartment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.apartment.entities.VehicleEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;

public interface VehicleServiceInt {
	public VehicleEntity addVehicle(VehicleEntity entity)throws DuplicateRecordException;

	public VehicleEntity update(VehicleEntity entity);

	public String delete(Long id)throws RecordNotFoundException;

	 VehicleEntity findByName(String name) throws RecordNotFoundException;

	public VehicleEntity findByPk(long id) throws RecordNotFoundException;

	public Page<VehicleEntity> search(VehicleEntity entity, long pageNo, int pageSize);

	

	public List<VehicleEntity> search(VehicleEntity entity);

}
