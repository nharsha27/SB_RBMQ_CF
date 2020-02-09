package com.sb.part1.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Configuration;import org.springframework.context.annotation.Profile;

@Profile("abc")
@Configuration
public class RabbitMQConfig {
    @Value("${spring.rabbitmq.template.default-receive-queue}")
    String queueName;

    @Value("${spring.rabbitmq.template.exchange}")
    String directExchange;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingkey;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(directExchange);
    }



    @Bean
    Binding binding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(routingkey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public AmqpTemplate rabbitTemplate123(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate123 = new RabbitTemplate(connectionFactory);
        rabbitTemplate123.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate123;
    }
}
