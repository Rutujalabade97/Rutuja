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

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.service.DeliveryServiceInt;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController 
{
	@Autowired
	DeliveryServiceInt delser;

	public DeliveryController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// RESTful API methods for Retrieval operation 
	@GetMapping("/{id}")
	public ResponseEntity<DeliveryEntity> findByPk(@PathVariable("id") Long id) throws Exception
	{
		DeliveryEntity se =delser.findByPk(id);
		return new ResponseEntity<DeliveryEntity>(se,HttpStatus.OK);
	}
	
	// RESTful API methods for Retrieval operation 
	@GetMapping("/")
	public ResponseEntity<?> search(DeliveryEntity bean)
	{
		return new ResponseEntity<>(delser.search(bean),HttpStatus.OK);
	}
	// RESTful API methods for Retrieval operation 
	@GetMapping("/search/{ownername}")
	public ResponseEntity<?> findByName(@PathVariable String ownername) throws RecordNotFoundException{

		DeliveryEntity de=delser.findByName(ownername);
		ResponseEntity<?> response=new ResponseEntity<> (de,HttpStatus.OK);
		return response;
	}
	// RESTful API methods for create operation 
	@PostMapping("/")
	public DeliveryEntity addDelivery(@RequestBody @Valid DeliveryEntity de) throws DuplicateRecordException {
		DeliveryEntity addDelivery=delser.addDelivery(de);
		return addDelivery;
	}

	// RESTful API methods for update operation 
	@PutMapping("/{id}")
	ResponseEntity<?> upadte(@RequestBody @Valid DeliveryEntity de) throws NoSuchElementException
	{
		DeliveryEntity update=delser.update(de);
		ResponseEntity<?> response=new ResponseEntity<>(update,HttpStatus.OK);
		return response;
	}
	// RESTful API methods for delete operation 
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) throws NoSuchElementException, RecordNotFoundException
	{
		delser.delete(id);
		return "successfully deleted";
	}

	// RESTful API methods for Retrieval operation 
	@GetMapping("/search/page")
	public ResponseEntity<?> searchByPage(DeliveryEntity de)
	{
		Page<DeliveryEntity> page=delser.searchByPage(de, 0, 2);
		ResponseEntity<?> response=new ResponseEntity<>(page,HttpStatus.OK);
		return response;
	}

}




