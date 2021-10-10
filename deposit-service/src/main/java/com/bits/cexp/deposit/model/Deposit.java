package com.bits.cexp.deposit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="deposit")
public class Deposit {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long depositNumber;	
	
    @Column(name = "balance")
    private double balance;
    
    @Column(name = "name")
    private String name;
    //private Customer holder;
    
    //private Arraylist<Tansaction> transactions;
	
	public Deposit() {

	}
	
	public Deposit(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}		

	public Long getDepositNumber() {
		return depositNumber;
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
}
