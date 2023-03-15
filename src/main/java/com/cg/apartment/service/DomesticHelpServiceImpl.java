package com.cg.apartment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.apartment.entities.DomesticHelpEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.repository.DomesticHelpDAOInt;

@Service
public class DomesticHelpServiceImpl implements DomesticHelpServiceInt
{
	@Autowired
	DomesticHelpDAOInt domdao;

	@Override
	public DomesticHelpEntity addDomestic(DomesticHelpEntity entity) throws DuplicateRecordException {
		Optional<DomesticHelpEntity>domestic=domdao.findById(entity.getId());
		if(domestic.isPresent()) {

			throw new DuplicateRecordException("Record already exist");

		}else {
			DomesticHelpEntity newDomestic=domdao.save(entity);
			return newDomestic;
		}
	}


	@Override
	public DomesticHelpEntity update(DomesticHelpEntity entity) {
		Optional<DomesticHelpEntity>Domestic=domdao.findById(entity.getId());
		if(Domestic.isPresent()) {
			DomesticHelpEntity domh=Domestic.get();

			domh.setId(entity.getId());
			
			domh.setFlatNo(entity.getFlatNo());
			domh.setOwnerName(entity.getOwnerName());
			domh.setName(entity.getName());
			domh.setHelpType(entity.getHelpType());
			domh.setArrivalTime(entity.getArrivalTime());
			domh.setDepartureTime(entity.getDepartureTime());
			domh.setLocaldate(entity.getLocaldate());


			DomesticHelpEntity update=domdao.save(domh);

			return update;
		}else {

			DomesticHelpEntity newVehicle=domdao.save(entity);
			return newVehicle;

		}

	}


	@Override
	public String delete(long id) throws RecordNotFoundException {
		Optional<DomesticHelpEntity>Domestic=domdao.findById(id);
		if(Domestic.isPresent()) {
			domdao.deleteById(id);
			return "Successfully Deleted";
		}else {throw new RecordNotFoundException("Enter the correct id");

		}

	}

	@Override
	public DomesticHelpEntity findByName(String name) throws RecordNotFoundException {
		if(name.matches(name)) {
			DomesticHelpEntity Domestic=domdao.findByName(name);
			return Domestic;
		}else
			throw new RecordNotFoundException("Record not found");

	}
	@Override
	public DomesticHelpEntity findByPk(long id) throws RecordNotFoundException {
		Optional<DomesticHelpEntity>Domestic=domdao.findById(id);
		if(!Domestic.isPresent()) {throw new RecordNotFoundException("Record Not Found");}
		else {
			return Domestic.get();
		}
	}

	

	@Override
	public Page<DomesticHelpEntity> search(DomesticHelpEntity entity, long pageNo, int pageSize) {
		PageRequest firstPagesWithTwoElements = PageRequest.of(0,2,Sort.by("name"));
		Page<DomesticHelpEntity> Domestic=domdao.findAll(firstPagesWithTwoElements);
		return Domestic;
	}


	@Override
	public List<DomesticHelpEntity> search(DomesticHelpEntity entity) {
		List<DomesticHelpEntity> se =domdao.findAll();
		return se;
	}

	
}
