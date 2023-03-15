package com.cg.apartment.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apartment.entities.UserEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.service.UserServiceInt;

@RestController
@RequestMapping("/api/user_entity/")
@CrossOrigin("*")
public class UserController
{

	public UserController() {}

	@Autowired
	UserServiceInt userservice;

	//http://localhost:8086/api/user_entity/2
	// RESTful API methods for Retrieval operation 
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> findByPk(@PathVariable("id") Long roleId) throws Exception
	{
		UserEntity user =userservice.findByPk(roleId);
		return new ResponseEntity<UserEntity>(user,HttpStatus.OK);
	}	

	// RESTful API methods for delete operation 
	@DeleteMapping("/{roleId}")
	public String delete(@PathVariable("roleId") long roleId) throws NoSuchElementException, RecordNotFoundException
	{
		userservice.delete(roleId);
		return "successfully deleted";
	}
	

	//http://localhost:8086/api/user_entity/search/user2
	// RESTful API methods for Retrieval operation 
	@GetMapping("/search/{loginId}")
	public ResponseEntity<UserEntity> findByLogin(@PathVariable String loginId) throws Exception
	{
		UserEntity user =userservice.findByLogin(loginId);
		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}	


	// RESTful API methods for create operation 
	@PostMapping(value="/add")
	public UserEntity addUser(@Valid @RequestBody UserEntity entity) {
		UserEntity adduser =userservice.addUser(entity);
		return adduser;
	}

	// RESTful API methods for update operation 
	//http://localhost:8086/api/user_entity/1
	@PutMapping("/{roleId}")
	ResponseEntity<?> update(@Valid @RequestBody UserEntity newEntity) throws RecordNotFoundException
	{
		UserEntity at=userservice.update(newEntity);
		ResponseEntity<?> response=new ResponseEntity<>(at,HttpStatus.OK);
		return response;
	}

	// RESTful API methods for update operation 
	//http://localhost:8086/api/user_entity/update
	@PostMapping(value="/update")
	UserEntity registerUser(@Valid @RequestBody UserEntity u) throws DuplicateRecordException
	{
		UserEntity ue=userservice.update(u);
		return ue;
	}



	// RESTful API methods for update operation 
	//http://localhost:8086/api/user_entity/changePassword1
	@PutMapping(value = "/changePassword")
	public ResponseEntity<String> changePassword(Long id, String password) throws RecordNotFoundException
	{
		userservice.changePassword(id,password);
		String msg="Password Updated Successfully for User";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

	
	// RESTful API methods for create operation 
	//http://localhost:8086/api/user_entity/login
	@PostMapping(value="/login")
	public ResponseEntity<String> authenticate(@Valid @RequestBody UserEntity userlogin) throws RecordNotFoundException{
		UserEntity user=userservice.authenticate(userlogin.getLoginId(),userlogin.getPassword());
		String msg ="Welcome" +user.getFirstName();
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	// RESTful API methods for Retrieval operation 
	@GetMapping("/search/ft/{firstName}")
	public List<UserEntity> search(String firstName){
		List<UserEntity> list = userservice.listAll(firstName);
		return list;
	}




}
