package com.sb.part1.controller;

import com.sb.part1.model.EmployeeDTO;
import com.sb.part1.service.EmployeeService;
import com.sb.part1.service.RabbitMQSender;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Controller {

    private final EmployeeService employeeService;

    private final RabbitMQSender rabbitMQSender;

    private final AmqpTemplate amqpTemplate;

    @PostMapping("/employees")
    public ResponseEntity createEmployee(@RequestBody EmployeeDTO employee) {

        employeeService.createEmployee(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/produce")
    public ResponseEntity producer(@RequestBody EmployeeDTO employee) {


        rabbitMQSender.send(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/produce/fan-out")
    public String producerFanout(@RequestParam("exchangeName") String exchangeName, @RequestBody EmployeeDTO employee) {

        amqpTemplate.convertAndSend(exchangeName,"",employee);

        return "Message sent to RabbitMQ topic exchange successfully";
    }

}
