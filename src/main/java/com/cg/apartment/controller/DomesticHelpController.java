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

import com.cg.apartment.entities.DomesticHelpEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.service.DomesticHelpServiceInt;

@RestController
@RequestMapping("/api/DomesticHelp")
public class DomesticHelpController 
{

	public DomesticHelpController() {
		super();
	}


	@Autowired
	DomesticHelpServiceInt domser;

	// RESTful API methods for Retrieval operation 
	@GetMapping("/g/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name) throws RecordNotFoundException
	{
		DomesticHelpEntity domestic=domser.findByName(name);
		ResponseEntity<?>response=new ResponseEntity<>(domestic,HttpStatus.OK);
		return response;
	}


	// RESTful API methods for Retrieval operation 
	@GetMapping("/{id}")
	public ResponseEntity <DomesticHelpEntity> findByPk(@PathVariable("id") Long id) throws Exception {

		DomesticHelpEntity domh=domser.findByPk(id);
		return new ResponseEntity<DomesticHelpEntity>(domh,HttpStatus.OK);

	}
	// RESTful API methods for Retrieval operation 
	@GetMapping("/")
	public ResponseEntity<?> search(DomesticHelpEntity entity)
	{

		return new ResponseEntity<>(domser.search(entity),HttpStatus.OK);

	}
	// RESTful API methods for create operation 
	@PostMapping("/")
	public ResponseEntity<DomesticHelpEntity> add(@RequestBody @Valid DomesticHelpEntity domh) throws NoSuchElementException, DuplicateRecordException
	{
		DomesticHelpEntity upd=domser.addDomestic(domh);
		return new ResponseEntity<DomesticHelpEntity>(upd,HttpStatus.CREATED);
	}

	// RESTful API methods for update operation 
	@PutMapping("/{id}")
	public ResponseEntity<DomesticHelpEntity> upadte(@RequestBody @Valid DomesticHelpEntity domh) throws NoSuchElementException
	{
		DomesticHelpEntity updveh=domser.update(domh);		
		ResponseEntity<DomesticHelpEntity> response=new ResponseEntity<>(updveh,HttpStatus.OK);
		return response;
	}
	
	// RESTful API methods for delete operation 
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) throws RecordNotFoundException 
	{
		domser.delete(id);
		return "successfully deleted";
	}
	
	// RESTful API methods for Retrieval operation 
	@GetMapping("/search")
	public ResponseEntity<?> search1(DomesticHelpEntity entity)
	{
		Page <DomesticHelpEntity>d=(Page<DomesticHelpEntity>) domser.search(entity, 0, 2);
		ResponseEntity<?> response=new ResponseEntity<>(d,HttpStatus.OK);
		return response;

	}

}
