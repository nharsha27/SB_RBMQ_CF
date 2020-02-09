package com.sb.part1.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
@Primary
public class RabbitMQFanoutConfig {

    @Bean
    Queue marketingQueue() {
        return new Queue(" marketingQueue", false);
    }

    @Bean
    Queue financeQueue() {
        return new Queue(" financeQueue", false);
    }

    @Bean
    Queue adminQueue() {
        return new Queue(" adminQueue", false);
    }


    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange");
    }

    @Bean
    Binding marketingBinding(Queue marketingQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(marketingQueue).to(fanoutExchange);
    }

    @Bean
    Binding financeBinding(Queue financeQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(financeQueue).to(fanoutExchange);
    }

    @Bean
    Binding adminBinding(Queue adminQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(adminQueue).to(fanoutExchange);
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    @Primary
    public AmqpTemplate rabbitTemplateFanout(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplateFanout = new RabbitTemplate(connectionFactory);
        rabbitTemplateFanout.setMessageConverter(jsonMessageConverter());
        return rabbitTemplateFanout;
    }
}

