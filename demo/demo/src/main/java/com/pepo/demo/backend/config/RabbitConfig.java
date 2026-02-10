package com.pepo.demo.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;

@Configuration
public class RabbitConfig {
    public static final String  USER_CREATED_EXCHANGE = "user.created.exchange";

    @Bean
    public FanoutExchange userCreatedExchange(){
        return new FanoutExchange(USER_CREATED_EXCHANGE);
    }
}
