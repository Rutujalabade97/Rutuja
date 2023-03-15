package com.cg.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.GardSalaryEntity;
import com.cg.apartment.entities.VehicleEntity;
@Repository
public interface VehicleDAOInt extends JpaRepository<VehicleEntity,Long> 
{
	@Query(value="select * from VehicleEntity", nativeQuery=true)
	public List<VehicleEntity >search(VehicleEntity entity,long pageNo,int pageSize);
	
	@Query(value="SELECT se FROM VehicleEntity  WHERE ownername", nativeQuery=true)
	 VehicleEntity findByName(String name);

}
