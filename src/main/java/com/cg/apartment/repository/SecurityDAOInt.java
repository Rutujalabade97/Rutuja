package com.cg.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.apartment.entities.GardSalaryEntity;
import com.cg.apartment.entities.SecurityEntity;
@Repository
public interface SecurityDAOInt extends JpaRepository<SecurityEntity,Long> {
	@Query(value="SELECT se FROM SecurityEntity se WHERE message=?1")
	SecurityEntity findByName(String message);
	
	@Query(value="select * from SecurityEntity", nativeQuery=true)
	public List<SecurityEntity> search(SecurityEntity entity, long pageNo, int pageSize);
}
