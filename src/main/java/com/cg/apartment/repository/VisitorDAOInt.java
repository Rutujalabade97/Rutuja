package com.cg.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.GardSalaryEntity;
import com.cg.apartment.entities.VisitorEntity;
@Repository
public interface VisitorDAOInt extends JpaRepository<VisitorEntity,Long> 
{
	@Query(value="select * from VisitorEntity", nativeQuery=true)
    public List<VisitorEntity> search(VisitorEntity entity, long pageNo, int pageSize);
	
	@Query(value="SELECT se FROM VisitorEntity  WHERE ownername", nativeQuery=true)
	public VisitorEntity findByName(String ownername);
	
}



