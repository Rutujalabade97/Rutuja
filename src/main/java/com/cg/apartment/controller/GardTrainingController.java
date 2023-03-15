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

import com.cg.apartment.entities.GardSalaryEntity;
import com.cg.apartment.entities.GardShiftEntity;
import com.cg.apartment.entities.GardTrainingEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.service.GardSalaryServiceInt;
import com.cg.apartment.service.GardTrainingServiceInt;

@RestController
@RequestMapping("/api/gardtraining/")
public class GardTrainingController 
{
	public GardTrainingController()
	{
		super();
	}
	@Autowired
	GardTrainingServiceInt trainingservice;
	// RESTful API methods for Retrieval operation 
	@GetMapping("/{id}")
	public ResponseEntity<GardTrainingEntity>  findByPk(@PathVariable ("id") Long id ) throws Exception {
		GardTrainingEntity gse1= trainingservice.findByPk(id);
		return new ResponseEntity<GardTrainingEntity>(gse1, HttpStatus.OK);

	}
	// RESTful API methods for Retrieval operation 
	@GetMapping("/")
	public ResponseEntity<?> gettrainingList(){
		List<GardTrainingEntity> getlist= trainingservice.gettrainingList();
		return new ResponseEntity<> (getlist,HttpStatus.OK);

	}
	// RESTful API methods for update operation 
	@PutMapping("/")
	ResponseEntity<?> update(@RequestBody GardTrainingEntity training)
	{
		GardTrainingEntity gse= trainingservice.update(training);
		ResponseEntity<?> response1=new ResponseEntity<>(gse,HttpStatus.OK);
		return response1;


	}
	// RESTful API methods for Retrieval operation 
	@GetMapping("/{name}")
	public ResponseEntity<?> findByName( String name){
		GardTrainingEntity shiftt = trainingservice.findByName(name);
		return new ResponseEntity<GardTrainingEntity>(shiftt, HttpStatus.OK);	
	}
	
	// RESTful API methods for create operation 
	@PostMapping("/adding")
	public ResponseEntity<?> add(@RequestBody GardTrainingEntity e1) throws DuplicateRecordException
	{
		GardTrainingEntity updated=  trainingservice.add(e1);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);

	}

	
	// RESTful API methods for delete operation 
	@DeleteMapping("/{id}")
	public String delete(@PathVariable ("id") long id ) throws RecordNotFoundException
	{
		trainingservice.delete(id);
		return "successfully deleted";

	}



}
