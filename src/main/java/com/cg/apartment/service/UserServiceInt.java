package com.cg.apartment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.apartment.entities.UserEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;

public interface UserServiceInt 
{
public UserEntity findByPk(long id) throws RecordNotFoundException;
	
	String delete(Long roleId) throws RecordNotFoundException;
	
	public UserEntity update(UserEntity entity);

	UserEntity addUser(UserEntity entity);
	
	public UserEntity findByLogin(String loginId) throws RecordNotFoundException;

	UserEntity registerUser(UserEntity entity) throws DuplicateRecordException;

	public List<UserEntity> search(String firstName);
	
	public String changePassword(Long id,String password) throws RecordNotFoundException;
    
	public UserEntity authenticate(String loginId,String password) throws RecordNotFoundException;

	List<UserEntity> listAll(String firstName);

	public Page<UserEntity> search(UserEntity entity, long pageNo, int pageSize);

	

	
    

}
