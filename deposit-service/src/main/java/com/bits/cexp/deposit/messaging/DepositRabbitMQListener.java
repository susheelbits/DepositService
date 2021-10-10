package com.bits.cexp.deposit.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.bits.cexp.deposit.dto.DepositDTO;



@Service
public class DepositRabbitMQListener {
	
    @RabbitListener(queues = "customer-command.queue")
    public void processOrder(DepositDTO deposit) {
    	System.out.println("Deposit Received: "+deposit);
    	
    	//If Id does not exists then, Add the Customer 
    	//If Id exists, then either update or delete the customer
    	//Send Acknowledgement of the operation 
    	
    }	
}
