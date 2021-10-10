package com.bits.cexp.deposit.service;

import java.util.List;

import com.bits.cexp.deposit.dto.DepositDTO;
import com.bits.cexp.deposit.model.Deposit;


public interface DepositService {

	 public Deposit saveDeposit(Deposit deposit);
	 
	 public DepositDTO getDepositById(Long depositId);
	 
	 public List<Deposit> getAllDeposits();
	 
	 public Deposit updateDeposit(Deposit deposit, long id);
	 
	 void deleteDeposit(long id);	
}
