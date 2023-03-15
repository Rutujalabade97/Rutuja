package com.cg.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.GardSalaryEntity;

@Repository
public interface GardSalaryDAOInt extends JpaRepository<GardSalaryEntity,Long> {

	@Query(value="select * from GardSalaryEntity", nativeQuery=true)
	public List<GardSalaryEntity> search(GardSalaryEntity entity, long pageNo, int pageSize);
	
	@Query(value="SELECT se FROM GardSalaryEntity  WHERE name", nativeQuery=true)
	public GardSalaryEntity findByName(String ownername);
	
}
