package com.bits.cexp.deposit.dto;


public class DepositDTO {


    private Long accountNumber;	
	

    private double balance;
    
    private String name;
    private CustomerDTO holder;
    
    //private Arraylist<Tansaction> transactions;

    private long customerId;	

	private String firstName; 
	
	public DepositDTO() {

	}
	
	public DepositDTO(String name, double balance, CustomerDTO holder) {
		this.name = name;
		this.balance = balance;
		this.holder = holder;
	}		

	public Long getDepositNumber() {
		return accountNumber;
	}

	public void setDepositNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}		

	public CustomerDTO getCustomer() {
		return holder;
	}
	
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}	
}
