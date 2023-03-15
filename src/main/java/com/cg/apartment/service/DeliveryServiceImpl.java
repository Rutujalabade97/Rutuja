package com.cg.apartment.service;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.repository.DeliverDAOInt;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryServiceInt{
	
	@Autowired
	DeliverDAOInt deldao;

	@Override
	public DeliveryEntity addDelivery(DeliveryEntity bean) throws DuplicateRecordException {
		java.util.Optional<DeliveryEntity> delivery=deldao.findById(bean.getId());
		if(delivery.isPresent()) {
			
			throw new DuplicateRecordException("Record already exist");
			
		}else {
			DeliveryEntity newDelivery=deldao.save(bean);
			return newDelivery;
		}
	}


	@Override
	public DeliveryEntity update(DeliveryEntity bean) {

		java.util.Optional<DeliveryEntity> delivery=deldao.findById(bean.getId());
		if(delivery.isPresent()) {
			DeliveryEntity de= delivery.get();
			de.setId(bean.getId());
			
			de.setDate(bean.getDate());
			de.setOwnerName(bean.getOwnerName());
			de.setStatus(bean.getStatus());
			de.setTime(bean.getTime());
			DeliveryEntity update= deldao.save(de);

			return update;
		}else {

			DeliveryEntity newDelivery=deldao.save(bean);
			return newDelivery;

		}
	}
		

	@Override
	public String delete(Long id) throws RecordNotFoundException {
		java.util.Optional<DeliveryEntity> delivery=deldao.findById(id);
		if(delivery.isPresent()) {
			deldao.deleteById(id);
			return "Successfully deleted";
		}
		else {
			throw new RecordNotFoundException("Enter the correct id");
		}
	}

	@Override
	public DeliveryEntity findByPk(long id) throws RecordNotFoundException {
		java.util.Optional<DeliveryEntity> delivery=deldao.findById(id);
		if(!delivery.isPresent())
			throw new RecordNotFoundException("Record not found");
		else
			return delivery.get();
	
	}

	@Override
	public Page<DeliveryEntity> searchByPage(DeliveryEntity bean, long pageNo, int pageSize) {
		PageRequest firstPageWithTwoElements= PageRequest.of(0, 2,Sort.by("ownername"));
		Page<DeliveryEntity> de=deldao.findAll(firstPageWithTwoElements);
		return de;
	
	}

	@Override
	public List<DeliveryEntity> search(DeliveryEntity bean) {
		List<DeliveryEntity> de=deldao.findAll();
		return de;
	}


	@Override
	public DeliveryEntity findByName(String ownername) {
		// TODO Auto-generated method stub

		DeliveryEntity delivery=deldao.findByName(ownername);
		return delivery;
	}



}

