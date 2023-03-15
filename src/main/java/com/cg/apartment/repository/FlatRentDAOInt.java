package com.cg.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.apartment.entities.FlatRentEntity;
import com.cg.apartment.entities.GardSalaryEntity;
@Repository
public interface FlatRentDAOInt extends JpaRepository<FlatRentEntity,Long> 
{
	@Query(value="SELECT se FROM FlatRentEntity se WHERE ownerName=?1")
    FlatRentEntity findByName(String ownerName);

	@Query(value="select * from FlatRentEntity", nativeQuery=true)
    public List<FlatRentEntity> search(FlatRentEntity entity, long pageNo, int pageSize);
}


