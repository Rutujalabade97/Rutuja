package com.cg.apartment.controller;

import java.util.List;

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

import com.cg.apartment.entities.DeliveryEntity;
import com.cg.apartment.entities.GardSalaryEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.service.GardSalaryServiceInt;


@RestController()
@RequestMapping("/api/gardsalary/")
public class GardSalaryController 
{
	public GardSalaryController()
	{
		super();
	}

	@Autowired
	GardSalaryServiceInt salserv;

	// RESTful API methods for Retrieval operation 
	@GetMapping("/{id}")
	public ResponseEntity<GardSalaryEntity>  findByPk(@PathVariable ("id") Long id ) throws Exception {
		GardSalaryEntity gse= salserv.findByPk(id);
		return new ResponseEntity<GardSalaryEntity>(gse, HttpStatus.OK);

	}
	// RESTful API methods for Retrieval operation 
	@GetMapping("/")
	public ResponseEntity<?> getSalaryList(){
		List<GardSalaryEntity> ge= salserv.getSalaryList();
		return new ResponseEntity<> (ge,HttpStatus.OK);

	}

	// RESTful API methods for update operation 
	@PutMapping("/")
	ResponseEntity<?> update(@RequestBody @Valid GardSalaryEntity sal)
	{
		GardSalaryEntity gse= salserv.update(sal);
		ResponseEntity<?> response=new ResponseEntity<>(gse,HttpStatus.OK);
		return response;


	}
	// RESTful API methods for create operation 
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid GardSalaryEntity e) throws DuplicateRecordException
	{
		
		GardSalaryEntity updated=  salserv.update(e);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);

	}
	// RESTful API methods for delete operation 
	@DeleteMapping("/{id}")
	public String delete(@PathVariable ("id") long id ) throws RecordNotFoundException
	{
		salserv.delete(id);
		return "successfully deleted";

	}
	// RESTful API methods for Retrieval operation 
	@GetMapping("/search")
	public ResponseEntity<?> search(GardSalaryEntity e)
	{
		Page<GardSalaryEntity> a=salserv.search(e, 0, 2);
		ResponseEntity<?> response=new ResponseEntity<>(a,HttpStatus.OK);
		return response;

	}




}
