package com.cg.apartment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.apartment.entities.FlatEntity;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.repository.FlatDAOInt;

@Service
public class FlatServiceImpl implements FlatServiceInt
{
	@Autowired
	FlatDAOInt secdao;
	
	@Override
	public FlatEntity add(FlatEntity bean) {
		

		FlatEntity newFlat=new FlatEntity();
		newFlat.setId(bean.getId());
		newFlat.setFloorNo(bean.getFloorNo());
		newFlat.setOwnerName(bean.getOwnerName());
		newFlat.setFlatNo(bean.getFlatNo());
		newFlat.setFlatType(bean.getFlatType());
		
		
		FlatEntity add= secdao.save(newFlat);
		return add;
	}
	

	@Override
	public FlatEntity update(FlatEntity bean) {
		Optional<FlatEntity> flat=secdao.findById(bean.getId());
		if(flat.isPresent()) {
			
			FlatEntity se= flat.get();
			se.setId(bean.getId());
			
			
			
			FlatEntity update= secdao.save(se);
			
			return update;
		}else {
			
			FlatEntity newFlat=secdao.save(bean);
			return newFlat;
			
		}
	}
	

	@Override
	public String delete(Long id) throws RecordNotFoundException {
		Optional<FlatEntity> flat=secdao.findById(id);
		if(flat.isPresent()) {
			secdao.deleteById(id);
			return "Successfully deleted";
		}
		else {
				throw new RecordNotFoundException("Enter the correct id");
			}
		}

	
	

	@Override
	public FlatEntity findByName(String ownerName) {
		FlatEntity flat=secdao.findByName(ownerName);
        return flat;
	}

	@Override
	public FlatEntity findByPk(long id) throws RecordNotFoundException {
Optional<FlatEntity> flat=secdao.findById(id);
		
		if(!flat.isPresent())
			throw new RecordNotFoundException("Record not found");
		else
			return flat.get();
	}

	@Override
	public List<FlatEntity> search(FlatEntity bean) {
		 List<FlatEntity> searching= secdao.findAll();
	        return searching;
	        }
	

	@Override
	public List<FlatEntity> getFlatEntityList() {
		return secdao.findAll();
	}

	@Override
	public Page<FlatEntity> search(FlatEntity bean, long pageNo, int pageSize) {

		PageRequest firstPageWithTwoElements = PageRequest.of(0, 2,Sort.by("ownerName"));
		Page<FlatEntity> ve=secdao.findAll(firstPageWithTwoElements);
		return ve;
		}

}
