package com.bits.cexp.deposit.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cexp.deposit.dto.DepositDTO;
import com.bits.cexp.deposit.model.Deposit;

@RestController
@RequestMapping(value = "/deposit-to-loan-rabbitmq/")
public class DepositRabbitMQController {

	
	/* @Autowired */
	DepositRabbitMQSender rabbitMQSender;

    @Autowired
    public DepositRabbitMQController(DepositRabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }
    

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("firstName") String firstName,
							@RequestParam("depositId") long depositId) {
		
		DepositDTO dep=new DepositDTO();
		dep.setBalance(depositId);
		dep.setName(firstName);
		rabbitMQSender.send(dep);
		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}	
}
