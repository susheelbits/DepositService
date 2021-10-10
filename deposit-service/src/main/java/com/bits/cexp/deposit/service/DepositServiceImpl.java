package com.bits.cexp.deposit.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bits.cexp.deposit.ResourceNotFoundException;
import com.bits.cexp.deposit.dto.DepositDTO;
import com.bits.cexp.deposit.dto.CustomerDTO;
import com.bits.cexp.deposit.model.Deposit;
import com.bits.cexp.deposit.repository.DepositRepository;
import com.bits.cexp.deposit.service.DepositService;

@Service
public class DepositServiceImpl implements DepositService {

	private DepositRepository depositRepository;

	public DepositServiceImpl(DepositRepository depositRepository) {
		super();
		this.depositRepository = depositRepository;
	}	
	
	public Deposit saveDeposit(Deposit deposit) {
		
    	System.out.println("Inside saveDeposit method of DepositServiceImpl");
    	Deposit acct = depositRepository.save(deposit);
    	System.out.println(" Saved and returned " + acct.toString());
    	return acct;
	}	
	
	public DepositDTO getDepositById(Long depositId) {
    	System.out.println("Inside getDepositById method of DepositServiceImpl");
		System.out.println("******* GET ACCOUNT BY ID");
		
		String baseUrl = "http://localhost:8081/api/customers/1"; RestTemplate
		restTemplate = new RestTemplate(); String result = restTemplate.getForObject(baseUrl, String.class);
		System.out.println("****** Printing the oject "+result.toString());
		 
		CustomerDTO customer = restTemplate.getForObject(baseUrl, CustomerDTO.class);
		
		System.out.println("*******Deposit  "+customer.getFirstName());
    	Deposit acctDb =  depositRepository.findById(depositId).orElseThrow(() -> 
									new ResourceNotFoundException("Deposit", "Id", depositId));
    	DepositDTO acctDto = new DepositDTO (acctDb.getName(), acctDb.getBalance(), customer);
    	acctDto.setDepositNumber(acctDb.getDepositNumber());
		/*
		 * acctDto.setCustomerId(acctDto.getCustomer().getCustomerId());
		 * acctDto.setFirstName(acctDto.getCustomer().getFirstName());
		 */
    	
    	return acctDto;
	}	

	@Override
	public Deposit updateDeposit(Deposit deposit, long id){
		System.out.println("******* updateDeposit ");
		
		// we need to check whether customer with given id is exist in DB or not
		Deposit existingDeposit = depositRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Deposit", "Id", id)); 
		
		existingDeposit.setName(deposit.getName());
		existingDeposit.setBalance(deposit.getBalance());
		// save existing customer to DB
		depositRepository.save(existingDeposit);

		String baseUrl = "http://localhost:9091/deposit-to-loan-rabbitmq/producer?firstName=emp1&depositId=1"; 
		RestTemplate restTemplate = new RestTemplate(); 
		String result = restTemplate.getForObject(baseUrl, String.class);
		
		System.out.println("******* stop ");
		return existingDeposit;
	}	 

	@Override
	public List<Deposit> getAllDeposits() {
		return depositRepository.findAll();
	}	

	@Override
	public void deleteDeposit(long id) {
		
		// check whether a customerRepository exist in a DB or not
		depositRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Deposit", "Id", id));
		depositRepository.deleteById(id);
	}		
}
