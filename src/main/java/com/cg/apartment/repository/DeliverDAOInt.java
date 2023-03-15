package com.cg.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.GardSalaryEntity;

@Repository
public interface DeliverDAOInt extends JpaRepository<DeliveryEntity,Long> 
{
	@Query(value="SELECT se FROM DeliveryEntity  WHERE ownername", nativeQuery=true)
	DeliveryEntity findByName(String ownername);

	@Query(value="select * from Delivery_entity", nativeQuery=true)
	public List<DeliveryEntity> search(DeliveryEntity entity, long pageNo, int pageSize);
}
