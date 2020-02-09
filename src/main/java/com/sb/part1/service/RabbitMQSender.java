package com.sb.part1.service;

import com.sb.part1.entity.EmployeeEntity;
import com.sb.part1.model.EmployeeDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.template.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingkey;

    public void send(EmployeeDTO employeeDTO) {
        rabbitTemplate.convertAndSend(exchange, routingkey, employeeDTO);
        System.out.println("Send msg = " + employeeDTO);

    }

}
