package com.cg.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.apartment.entities.FlatEntity;
import com.cg.apartment.entities.GardSalaryEntity;
@Repository
public interface FlatDAOInt extends JpaRepository<FlatEntity,Long>
{
	@Query(value="SELECT se FROM FlatEntity se WHERE ownerName=?1")
    FlatEntity findByName(String ownerName);

	@Query(value="SELECT  * FROM  FlatEntity", nativeQuery=true)
    public List<FlatEntity> search(FlatEntity entity, long pageNo, int pageSize);
}


