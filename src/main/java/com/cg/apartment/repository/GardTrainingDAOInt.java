package com.cg.apartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.GardTrainingEntity;

@Repository
public interface GardTrainingDAOInt extends JpaRepository<GardTrainingEntity,Long> 
{
	@Query(value="SELECT se FROM GardTrainingEntity  WHERE name", nativeQuery=true)
	public GardTrainingEntity findByName(String ownername);
	

}
