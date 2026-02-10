package com.pepo.demo.worker.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String USER_CREATED_EXCHANGE = "user.created.exchange";
    public static final String USER_CREATED_QUEUE = "user.created.worker1.queue";
    public static final String USER_CREATED_AUDIT_QUEUE = "user.created.audit.queue";

    @Bean
    public FanoutExchange userCreatedExchange(){
        return new FanoutExchange(USER_CREATED_EXCHANGE);
    }

    @Bean
    public Queue userCreatedQueue(){
        return new Queue(USER_CREATED_QUEUE, true);
    }

    @Bean
    public Binding userCreatedBinding(Queue userCreatedQueue, FanoutExchange userCreatedExchange){
        return BindingBuilder.bind(userCreatedQueue).to(userCreatedExchange);
    }

    @Bean
    public Queue userCreatedAudit() {
        return new Queue(USER_CREATED_AUDIT_QUEUE, true);
    }

    @Bean
    public Binding userCreatedAuditBinding(Queue userCreatedAudit, FanoutExchange userCreatedExchange){
        return BindingBuilder.bind(userCreatedAudit).to(userCreatedExchange);
    }

}
