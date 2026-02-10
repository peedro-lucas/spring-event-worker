package com.pepo.demo.backend.publisher;

import com.pepo.demo.backend.events.UserCreatedEvent;
import com.pepo.demo.backend.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public UserEventPublisher (RabbitTemplate rabbitTemplate ){
        this.rabbitTemplate = rabbitTemplate;

    }

    public void publishUserCreated(UserCreatedEvent event){
        rabbitTemplate.convertAndSend(RabbitConfig.USER_CREATED_EXCHANGE, "", event);
        System.out.println("chegou no rabbit");
    }
}
