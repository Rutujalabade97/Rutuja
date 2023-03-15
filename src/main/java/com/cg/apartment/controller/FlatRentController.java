package com.cg.apartment.controller;
import java.util.NoSuchElementException;


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

import com.cg.apartment.entities.FlatRentEntity;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.service.FlatRentServiceInt;
import com.cg.apartment.service.FlatServiceInt;



@RestController
@RequestMapping("/api/flatrent")
public class FlatRentController 
{
	public FlatRentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	FlatRentServiceInt frser;
	// RESTful API methods for Retrieval operation 
	@GetMapping("/{id}")
	public ResponseEntity<FlatRentEntity> findByPk(@PathVariable("id") Long id) throws Exception
	{
		FlatRentEntity ve =frser.findByPk(id);
		return new ResponseEntity<FlatRentEntity>(ve,HttpStatus.OK);
	}	
	// RESTful API methods for Retrieval operation 
	@GetMapping("/")
	public ResponseEntity<?> getFlatRentEntityList()
	{
		return new ResponseEntity<>(frser.getFlatRentEntityList(),HttpStatus.OK);
	}
	// RESTful API methods for Retrieval operation 
	@GetMapping("/search/{ownerName}")
	public ResponseEntity<?> findByName(@PathVariable String ownerName) throws RecordNotFoundException{

		FlatRentEntity se=frser.findByName(ownerName);
		ResponseEntity<?> response=new ResponseEntity<> (se,HttpStatus.OK);
		return response;
	}

	// RESTful API methods for create operation 
	@RequestMapping(value="/add", method= RequestMethod.POST)
	public ResponseEntity<FlatRentEntity> add(@RequestBody  FlatRentEntity se) throws NoSuchElementException
	{
		long upd=frser.add(se);
		return new ResponseEntity<FlatRentEntity>(HttpStatus.CREATED);
	}

	// RESTful API methods for update operation 
	@PostMapping("/")
	public FlatRentEntity addFlatRent(@RequestBody FlatRentEntity ve) 
	{
		FlatRentEntity upd=frser.update(ve);
		return  upd;
	} 
	// RESTful API methods for update operation 
	@PutMapping("/")
	ResponseEntity<?> upadte(@RequestBody FlatRentEntity ve) throws NoSuchElementException
	{
		FlatRentEntity at=frser.update(ve);
		ResponseEntity<?> response=new ResponseEntity<>(at,HttpStatus.OK);
		return response;
	}
	// RESTful API methods for delete operation 
	@DeleteMapping("{/id}")
	public String delete(@PathVariable("id") long id) throws NoSuchElementException, RecordNotFoundException
	{
		frser.delete(id);
		return "successfully deleted";
	}

	
	// RESTful API methods for Retrieval operation 
	@GetMapping("/search")
	public ResponseEntity<?> search(FlatRentEntity e)
	{
		Page<FlatRentEntity> a=frser.search(e, 0, 2);
		ResponseEntity<?> response=new ResponseEntity<>(a,HttpStatus.OK);
		return response;

	}


}
