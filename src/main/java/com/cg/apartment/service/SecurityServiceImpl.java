package com.cg.apartment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.apartment.entities.SecurityEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.repository.SecurityDAOInt;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class SecurityServiceImpl implements SecurityServiceInt{

	@Autowired
	SecurityDAOInt secdao;
	
	@Override
	public SecurityEntity addSecurity(SecurityEntity bean) throws DuplicateRecordException {
		java.util.Optional<SecurityEntity> security=secdao.findById(bean.getId());
		if(security.isPresent()) {
			
			throw new DuplicateRecordException("Record already exist");
			
		}else {
			SecurityEntity newSecurity=secdao.save(bean);
			return newSecurity;
		}
	}

	@Override
	public SecurityEntity update(SecurityEntity bean) {
		java.util.Optional<SecurityEntity> security=secdao.findById(bean.getId());
		if(security.isPresent()) {
			SecurityEntity se= security.get();
			se.setId(bean.getId());
			
			se.setMessage(bean.getMessage());
			se.setAlert(bean.getAlert());
			SecurityEntity update= secdao.save(se);
			
			return update;
		}else {
			
			SecurityEntity newSecurity=secdao.save(bean);
			return newSecurity;
			
		}
	}
	@Override
	public String delete(Long id) throws RecordNotFoundException {
		java.util.Optional<SecurityEntity> security=secdao.findById(id);
		if(security.isPresent()) {
			secdao.deleteById(id);
			return "Successfully deleted";
		}
		else {
				throw new RecordNotFoundException("Enter the correct id");
			}
		}
	@Override
	public SecurityEntity findByPk(long id) throws RecordNotFoundException {
		java.util.Optional<SecurityEntity> security=secdao.findById(id);
		if(!security.isPresent())
			throw new RecordNotFoundException("Record not found");
		else
			return security.get();
	}

	@Override
	public Page<SecurityEntity> searchByPage(SecurityEntity bean, long pageNo, int pageSize) {
		PageRequest firstPageWithTwoElements= PageRequest.of(0, 2,Sort.by("ownername"));
		Page<SecurityEntity> se=secdao.findAll(firstPageWithTwoElements);
		return se;
	}

	@Override
	public List<SecurityEntity> search(SecurityEntity bean) {
		List<SecurityEntity> se=secdao.findAll();
		return se;
	}

	@Override
	public SecurityEntity findByName(String message) throws RecordNotFoundException {
		if(message.matches(message)) {
			SecurityEntity security=secdao.findByName(message);
			return security;
		}else
			throw new RecordNotFoundException("Record not found");
			
		}
		

}
