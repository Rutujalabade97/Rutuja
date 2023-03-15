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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apartment.entities.VisitorEntity;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.service.VisitorServiceInt;

@RestController
@RequestMapping("/api/visitor")
public class VisitorController 
{
	public VisitorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	VisitorServiceInt visser;
	
	
	// RESTful API methods for Retrieval operation 
	@GetMapping("/{id}")
	public ResponseEntity<VisitorEntity> findByPk(@PathVariable("id") Long id) throws Exception
	{
		VisitorEntity ve =visser.findByPk(id);
		return new ResponseEntity<VisitorEntity>(ve,HttpStatus.OK);
	}	
	
	// RESTful API methods for Retrieval operation 
	@GetMapping("/")
	public ResponseEntity<?> getVisitorEntityList()
	{
		return new ResponseEntity<>(visser.getVisitorEntityList(),HttpStatus.OK);
	}



	// RESTful API methods for create operation 
	@RequestMapping(value="/add", method= RequestMethod.POST)
	public ResponseEntity<VisitorEntity> add(@RequestBody  VisitorEntity se) throws NoSuchElementException
	{
		VisitorEntity upd=visser.update(se);
		return new ResponseEntity<VisitorEntity>(upd,HttpStatus.CREATED);
	}

	// RESTful API methods for create operation 
	@PostMapping("/")
	public long addVisitor(@RequestBody @Valid  VisitorEntity ve) 
	{
		long upd=visser.add(ve);
		return  upd;
	} 

	// RESTful API methods for update operation 
	@PutMapping("/")
	ResponseEntity<?> upadte(@RequestBody @Valid VisitorEntity ve) throws NoSuchElementException
	{
		VisitorEntity at=visser.update(ve);
		ResponseEntity<?> response=new ResponseEntity<>(at,HttpStatus.OK);
		return response;
	}
	
	
	// RESTful API methods for delete operation 
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) throws NoSuchElementException, RecordNotFoundException
	{
		visser.delete(id);
		return "successfully deleted";
	}

	// RESTful API methods for Retrieval operation 
	@GetMapping("/s")
	public ResponseEntity<?> search(VisitorEntity ve)
	{
		Page<VisitorEntity> a=visser.search(ve, 0, 2);
		ResponseEntity<?> response=new ResponseEntity<>(a,HttpStatus.OK);
		return response;
	} 


}
