package com.cg.apartment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.GardSalaryEntity;
import com.cg.apartment.entities.UserEntity;
@Repository
public interface UserDAOInt extends JpaRepository<UserEntity,Long>
{
	@Query(value="SELECT ue FROM UserEntity ue WHERE ue.loginId=?1")
	UserEntity findByLogin(String loginId);

	@Query(value="UPDATE UserEntity u set password=?2 WHERE id=?1")
	@Modifying
	void passwordReset(Long id, String password);
	
	public Optional<UserEntity>findByLoginIdAndPassword(String loginId,String password);

	@Query("SELECT u FROM UserEntity u WHERE CONCAT(u.firstName, u.lastName, u.loginId, u.password, u.roleId, u.emailId, u.mobileNo) LIKE %?1%")
	public List<UserEntity> search(String firstName);

	public Optional<UserEntity> findById(Long id);
	
	@Query(value="SELECT * FROM UserEntity", nativeQuery=true)
    public List<UserEntity> search(UserEntity entity, long pageNo, int pageSize);
	
	
	
}


