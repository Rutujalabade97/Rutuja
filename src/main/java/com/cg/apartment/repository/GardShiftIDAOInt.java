package com.cg.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.GardShiftEntity;

@Repository
public interface GardShiftIDAOInt extends JpaRepository<GardShiftEntity,Long>
{
	@Query(value="select * from GardShiftEntity", nativeQuery=true)
	public List<GardShiftEntity> search(GardShiftEntity entity, long pageNo, int pageSize);
	
	@Query(value="SELECT se FROM GardShiftEntity  WHERE name", nativeQuery=true)
	public GardShiftEntity findByName(String ownername);
	

}
