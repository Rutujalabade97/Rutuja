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

import com.cg.apartment.entities.VehicleEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.service.VehicleServiceInt;

@RestController
@RequestMapping("/api/Vehicle")
public class VehicleController 
{
	public VehicleController() {
		super();
	}

	@Autowired
	VehicleServiceInt vehser;

	// RESTful API methods for Retrieval operation 
	@GetMapping("/s/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name) throws RecordNotFoundException
	{
		VehicleEntity ve=vehser.findByName(name);
		ResponseEntity<?>response=new ResponseEntity<>(ve,HttpStatus.OK);
		return response;
	}

	// RESTful API methods for Retrieval operation 
	@GetMapping("/{id}")
	public ResponseEntity <VehicleEntity> findByPk(@PathVariable("id") Long id) throws Exception {

		VehicleEntity ve=vehser.findByPk(id);
		return new ResponseEntity<VehicleEntity>(ve,HttpStatus.OK);

	}


	// RESTful API methods for Retrieval operation 
	@GetMapping("/")
	public ResponseEntity<?> search1(VehicleEntity entity)
	{

		return new ResponseEntity<>(vehser.search(entity),HttpStatus.OK);

	}


	// RESTful API methods for create operation 
	@PostMapping("/")
	public ResponseEntity<VehicleEntity> add(@RequestBody @Valid VehicleEntity ve) throws NoSuchElementException, DuplicateRecordException
	{
		VehicleEntity upd=vehser.addVehicle(ve);
		return new ResponseEntity<VehicleEntity>(upd,HttpStatus.CREATED);
	}

	// RESTful API methods for update operation 
	@PutMapping("/{id}")
	public ResponseEntity<VehicleEntity> upadte(@RequestBody @Valid VehicleEntity ve) throws NoSuchElementException
	{
		VehicleEntity updveh=vehser.update(ve);		
		ResponseEntity<VehicleEntity> response=new ResponseEntity<>(updveh,HttpStatus.OK);
		return response;


	}
	// RESTful API methods for delete operation 
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) throws RecordNotFoundException 
	{
		vehser.delete(id);
		return "successfully deleted";
	}


	// RESTful API methods for Retrieval operation 
	@GetMapping("/search")
	public ResponseEntity<?> search(VehicleEntity entity)
	{
		Page <VehicleEntity>v=(Page<VehicleEntity>) vehser.search(entity, 0, 2);
		ResponseEntity<?> response=new ResponseEntity<>(v,HttpStatus.OK);
		return response;

	}


}
