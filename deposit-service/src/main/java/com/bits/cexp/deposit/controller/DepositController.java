package com.bits.cexp.deposit.controller;

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
import org.springframework.web.client.RestTemplate;

import com.bits.cexp.deposit.dto.DepositDTO;
import com.bits.cexp.deposit.model.Deposit;
import com.bits.cexp.deposit.service.DepositService;

@RestController
@RequestMapping("/api/deposits")
public class DepositController {

	private DepositService depositService;

	public DepositController(DepositService depositService) {
		super();
		this.depositService = depositService;
	}	

	// build create Customer REST API
	@PostMapping()
	public ResponseEntity<Deposit> saveCustomer(@RequestBody Deposit deposit){
		return new ResponseEntity<Deposit>(depositService.saveDeposit(deposit), HttpStatus.CREATED);
	}	

	// build get all employees REST API
	@GetMapping
	public List<Deposit> getAllDeposits(){
		return depositService.getAllDeposits();
	}	

	// build get customer by id REST API
	// http://localhost:8080/api/deposits/1
	@GetMapping("{id}")
	public ResponseEntity<DepositDTO> getDepositById(@PathVariable("id") long depositId){
		return new ResponseEntity<DepositDTO>(depositService.getDepositById(depositId), HttpStatus.OK);
	}

	// build update customer REST API
	// http://localhost:8080/api/deposits/1
	@PutMapping("{id}")
	public ResponseEntity<Deposit> updateDeposit(@PathVariable("id") long id
												  ,@RequestBody Deposit deposit){
		return new ResponseEntity<Deposit>(depositService.updateDeposit(deposit, id), HttpStatus.OK);
	}	

	// build delete customer REST API
	// http://localhost:8080/api/deposits/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDeposit(@PathVariable("id") long id){
		
		// delete employee from DB
		depositService.deleteDeposit(id);
		
		return new ResponseEntity<String>("Deposit deleted successfully!.", HttpStatus.OK);
	}		

}

