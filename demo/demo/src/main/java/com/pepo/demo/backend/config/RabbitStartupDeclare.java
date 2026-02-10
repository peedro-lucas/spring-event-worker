package com.pepo.demo.backend.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitStartupDeclare {

    @Bean
    CommandLineRunner declareExchange(AmqpAdmin amqpAdmin, FanoutExchange userCreatedExchange) {
        return args -> {
            amqpAdmin.declareExchange(userCreatedExchange);
            System.out.println("✅ Declarou exchange: " + userCreatedExchange.getName());
        };
    }
}
