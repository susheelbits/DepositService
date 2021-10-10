package com.bits.cexp.deposit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bits.cexp.deposit.model.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

}
