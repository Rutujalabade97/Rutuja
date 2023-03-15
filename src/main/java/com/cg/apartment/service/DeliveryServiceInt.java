package com.cg.apartment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;

public interface DeliveryServiceInt {
public DeliveryEntity addDelivery(DeliveryEntity bean) throws DuplicateRecordException;
	
	public DeliveryEntity update(DeliveryEntity bean);
	
	String delete(Long id) throws RecordNotFoundException;
	
	public DeliveryEntity findByPk(long id) throws RecordNotFoundException;
	
	public Page<DeliveryEntity> searchByPage(DeliveryEntity bean, long pageNo, int pageSize);
	
	public List<DeliveryEntity> search(DeliveryEntity bean);

	DeliveryEntity findByName(String ownername);

	
}
