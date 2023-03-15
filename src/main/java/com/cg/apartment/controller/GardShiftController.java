package com.cg.apartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cg.apartment.entities.GardShiftEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.service.GardShiftServiceInt;

@RestController()
@RequestMapping("/api/gardshift")
public class GardShiftController 
{
	@Autowired
	GardShiftServiceInt shiftservice;
	public GardShiftController() {
		super();
	}
	// RESTful API methods for Retrieval operation 
	@GetMapping("/{id}")
	public ResponseEntity<GardShiftEntity> findByPk(@PathVariable long id){
		GardShiftEntity shiftt = shiftservice.findByPk(id);
		return new ResponseEntity<GardShiftEntity>(shiftt, HttpStatus.OK);	
	}
	// RESTful API methods for Retrieval operation 
	@GetMapping("/{name}")
	public ResponseEntity<?> findByName( String name){
		GardShiftEntity shiftt = shiftservice.findByName(name);
		return new ResponseEntity<GardShiftEntity>(shiftt, HttpStatus.OK);	
	}
	// RESTful API methods for Retrieval operation 
	@GetMapping("/")
	public ResponseEntity<?> search(GardShiftEntity obejct){
		List<GardShiftEntity> ge= shiftservice.search(obejct);
		return new ResponseEntity<> (ge,HttpStatus.OK);

	}
	// RESTful API methods for update operation 
	@PutMapping("/")
	ResponseEntity<?> update(@RequestBody GardShiftEntity sal)
	{
		GardShiftEntity gse= shiftservice.update(sal);
		ResponseEntity<?> response=new ResponseEntity<>(gse,HttpStatus.OK);
		return response;


	}
	// RESTful API methods for update operation 
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody GardShiftEntity e) throws DuplicateRecordException
	{
		
		GardShiftEntity updated=  shiftservice.add(e);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);

	}
	// RESTful API methods for delete operation 
	@DeleteMapping("/{id}")
	public String delete(@PathVariable ("id") long id ) throws RecordNotFoundException
	{
		shiftservice.delete(id);
		return "successfully deleted";

	}



}
