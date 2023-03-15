package com.cg.apartment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.apartment.entities.FlatRentEntity;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.repository.FlatRentDAOInt;

@Service
public class FlatRentServiceImpl implements FlatRentServiceInt
{
	@Autowired
	FlatRentDAOInt frdaoi;
	

	@Override
	public long add(FlatRentEntity bean) {
		FlatRentEntity flatr=frdaoi.save(bean);
		return flatr.getId();
	}

	@Override
	public FlatRentEntity update(FlatRentEntity bean) {
Optional<FlatRentEntity> flatr=frdaoi.findById(bean.getId());
		
		
		if(flatr.isPresent()) {
			
			FlatRentEntity ve= flatr.get();
			ve.setId(bean.getId());
			
			
			FlatRentEntity update= frdaoi.save(ve);
			
			return update;
		}else {
			
			FlatRentEntity newFlatRent=frdaoi.save(bean);
			return newFlatRent;
			
		}
	}

	@Override
	public String delete(Long id) throws RecordNotFoundException {
		 Optional<FlatRentEntity> flatrent=frdaoi.findById(id);
			if(flatrent.isPresent()) {
			
				frdaoi.deleteById(id);
				return "Successfully deleted";
			}
		 	else {
					throw new RecordNotFoundException("Enter the correct id");
				}
		}

	@Override
	public FlatRentEntity findByName(String ownerName) {
		FlatRentEntity flatrent=frdaoi.findByName(ownerName);
        return flatrent;
	}

	@Override
	public FlatRentEntity findByPk(long id) throws RecordNotFoundException {
		Optional<FlatRentEntity> flatrent=frdaoi.findById(id);
		if(!flatrent.isPresent())
			throw new RecordNotFoundException("Record not found");
		else
			return flatrent.get();
	}

	@Override
	public Page<FlatRentEntity> search(FlatRentEntity bean, long pageNo, int pageSize) {
		PageRequest firstPageWithTwoElements = PageRequest.of(0, 2,Sort.by("ownerName"));
		Page<FlatRentEntity> ve=frdaoi.findAll(firstPageWithTwoElements);
		return ve;
		}


	@Override
	public List<FlatRentEntity> search(FlatRentEntity bean) {
		  List<FlatRentEntity> searching= frdaoi.findAll();
	        return searching;
	        }

	@Override
	public List<FlatRentEntity> getFlatRentEntityList() {
		// TODO Auto-generated method stub
		return frdaoi.findAll();
	}
}
