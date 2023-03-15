package com.cg.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.DomesticHelpEntity;
import com.cg.apartment.entities.GardSalaryEntity;
@Repository
public interface DomesticHelpDAOInt extends JpaRepository<DomesticHelpEntity,Long>
{
	@Query(value="select * from DomesticHelpEntity", nativeQuery=true)
	public List<DomesticHelpEntity >search(DomesticHelpEntity entity,long pageNo,int pageSize);

	@Query(value="SELECT se FROM DomesticHelpEntity  WHERE ownername", nativeQuery=true)
	public DomesticHelpEntity findByName(String ownername);
	


}
