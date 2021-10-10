package com.bits.cexp.deposit.messaging;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bits.cexp.deposit.dto.DepositDTO;
import com.bits.cexp.deposit.model.Deposit;

@Service
public class DepositRabbitMQSender {
	private RabbitTemplate rabbitTemplate;

    @Autowired
    public DepositRabbitMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
	@Value("${spring.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${spring.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(DepositDTO depDto) {
		rabbitTemplate.convertAndSend(exchange, routingkey, depDto);
		System.out.println("Send msg = " + depDto);
	    
	}	
}
