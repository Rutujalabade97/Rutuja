package com.cg.apartment.controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apartment.entities.SecurityEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.service.SecurityServiceInt;

@RestController
@RequestMapping("/api/security/")
public class SecurityController 
{
	public SecurityController() {
		super();
	}

	@Autowired
	SecurityServiceInt secser;
	
	
	// RESTful API methods for Retrieval operation 
	@GetMapping("/{id}")
	public ResponseEntity<SecurityEntity> findByPk(@PathVariable("id") Long id) throws Exception
	{
		SecurityEntity se =secser.findByPk(id);
		return new ResponseEntity<SecurityEntity>(se,HttpStatus.OK);
	}

	// RESTful API methods for Retrieval operation 
	@GetMapping("/")
	public ResponseEntity<?> search(SecurityEntity bean)
	{
		return new ResponseEntity<>(secser.search(bean),HttpStatus.OK);
	}
	
	// RESTful API methods for Retrieval operation 
	@GetMapping("/search/{message}")
	public ResponseEntity<?> findByName(@PathVariable String message) throws RecordNotFoundException{

		SecurityEntity se=secser.findByName(message);
		ResponseEntity<?> response=new ResponseEntity<> (se,HttpStatus.OK);
		return response;
	}

	// RESTful API methods for create operation 
	@PostMapping("/")
	public SecurityEntity addSecurity(@RequestBody @Valid SecurityEntity se) throws DuplicateRecordException {
		SecurityEntity addSecurity=secser.addSecurity(se);
		return addSecurity;
	}

	// RESTful API methods for update operation 
	@PutMapping("/{id}")
	ResponseEntity<?> upadte(@RequestBody @Valid SecurityEntity se) throws NoSuchElementException
	{
		SecurityEntity at=secser.update(se);
		ResponseEntity<?> response=new ResponseEntity<>(at,HttpStatus.OK);
		return response;
	}

	// RESTful API methods for delete operation 
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) throws NoSuchElementException, RecordNotFoundException
	{
		secser.delete(id);
		return "successfully deleted";
	}
	
	// RESTful API methods for Retrieval operation 
	@GetMapping("/search/page")
	public ResponseEntity<?> searchByPage(SecurityEntity se)
	{
		Page<SecurityEntity> page=secser.searchByPage(se, 0, 2);
		ResponseEntity<?> response=new ResponseEntity<>(page,HttpStatus.OK);
		return response;
	}

}



