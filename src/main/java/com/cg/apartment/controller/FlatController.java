package com.cg.apartment.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apartment.entities.FlatEntity;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.service.FlatServiceInt;

@RestController
@RequestMapping("api//flat")
public class FlatController 
{
	public FlatController() {
		super();
		// TODO Auto-generated constructor
	}

	@Autowired
	FlatServiceInt fser;
	// RESTful API methods for Retrieval operation 
	@GetMapping("/{id}")
	public ResponseEntity<FlatEntity> findByPk(@PathVariable("id") Long id) throws Exception
	{
		FlatEntity se =fser.findByPk(id);
		return new ResponseEntity<FlatEntity>(se,HttpStatus.OK);
	}	
	// RESTful API methods for Retrieval operation 
	@GetMapping("/")
	public ResponseEntity<?> getFlatEntityList()
	{
		return new ResponseEntity<>(fser.getFlatEntityList(),HttpStatus.OK);
	}
	// RESTful API methods for Retrieval operation 
	@GetMapping("/search/{ownerName}")
	public ResponseEntity<?> findByName(@PathVariable String ownerName) throws RecordNotFoundException{

		FlatEntity se=fser.findByName(ownerName);
		ResponseEntity<?> response=new ResponseEntity<> (se,HttpStatus.OK);
		return response;
	}

	// RESTful API methods for create operation 
	@RequestMapping(value="/add", method= RequestMethod.POST)
	public ResponseEntity<FlatEntity> add(@RequestBody  FlatEntity se) throws NoSuchElementException
	{
		FlatEntity flat = new  FlatEntity(se.getOwnerName(),se.getFlatNo(),se.getFloorNo(),se.getFlatType());
		FlatEntity upd=fser.add(flat);
		return new ResponseEntity<FlatEntity>(upd,HttpStatus.CREATED);
	}
	// RESTful API methods for update operation 
	@PutMapping("/{id}")
	ResponseEntity<?> upadte(@RequestBody FlatEntity se) throws NoSuchElementException
	{
		FlatEntity at=fser.update(se);
		ResponseEntity<?> response=new ResponseEntity<>(at,HttpStatus.OK);
		return response;
	}
	// RESTful API methods for delete operation 
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) throws NoSuchElementException, RecordNotFoundException
	{
		fser.delete(id);
		return "successfully deleted";
	}

	// RESTful API methods for Retrieval operation 
	@GetMapping("/search")
	public ResponseEntity<?> search(FlatEntity e)
	{
		Page<FlatEntity> a=fser.search(e, 0, 2);
		ResponseEntity<?> response=new ResponseEntity<>(a,HttpStatus.OK);
		return response;

	}
}



