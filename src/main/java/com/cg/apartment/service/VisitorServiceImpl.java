package com.cg.apartment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cg.apartment.entities.VehicleEntity;
import com.cg.apartment.entities.VisitorEntity;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.repository.VisitorDAOInt;

@Service
public class VisitorServiceImpl implements VisitorServiceInt
{
	@Autowired
	VisitorDAOInt visdaoi;

	@Override
	public long add(VisitorEntity bean) {
		VisitorEntity visitor=visdaoi.save(bean);
		return visitor.getId();
	}

	@Override
	public VisitorEntity update(VisitorEntity bean) {
Optional<VisitorEntity> visitor=visdaoi.findById(bean.getId());
		
		
		if(visitor.isPresent()) {
			
			VisitorEntity ve= visitor.get();
			
			ve.setId(bean.getId());
			
			ve.setName(bean.getName());
			ve.setOwnerName(bean.getOwnerName());
			ve.setFlatNo(bean.getFlatNo());
			ve.setDate(bean.getDate());
			ve.setArrivalTime(bean.getArrivalTime());
			ve.setDepartureTime(bean.getDepartureTime());
			
			VisitorEntity update= visdaoi.save(ve);
			
			return update;
		}else {
			
			VisitorEntity newVisitor=visdaoi.save(bean);
			return newVisitor;
			
		}
	}
	@Override
	public String delete(Long id) throws RecordNotFoundException {
		Optional<VisitorEntity> visitor=visdaoi.findById(id);
		if(visitor.isPresent()) {
		
			visdaoi.deleteById(id);
			return "Successfully deleted";
		}
	 	else {
				throw new RecordNotFoundException("Enter the correct id");
			}
	}


	@Override
	
	public VisitorEntity findByName(String name) throws RecordNotFoundException {
		if(name.matches(name)) {
			VisitorEntity vehicle=visdaoi.findByName(name);
		return vehicle;
	}else
		throw new RecordNotFoundException("Record not found");
		
	}
		
	@Override
	public List<VisitorEntity> search(VisitorEntity bean) {
		List<VisitorEntity> se=visdaoi.findAll();
		return se;
	}

	@Override
	public List<VisitorEntity> getVisitorEntityList() {
		// TODO Auto-generated method stub
		return visdaoi.findAll();
	}

	@Override
	public VisitorEntity findByPk(long id) throws RecordNotFoundException {
		Optional<VisitorEntity> visitor=visdaoi.findById(id);
		if(!visitor.isPresent())
			throw new RecordNotFoundException("Record not found");
		else
			return visitor.get();
	}


	@Override
	public Page<VisitorEntity> search(VisitorEntity entity, long pageNo, int pageSize) {
		PageRequest firstPageWithTwoElements = PageRequest.of(0, 2,Sort.by("name"));
		Page<VisitorEntity> ve=visdaoi.findAll(firstPageWithTwoElements);
		return ve;  
	} 
	
	
	
}
