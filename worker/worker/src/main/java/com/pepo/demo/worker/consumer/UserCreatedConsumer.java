package com.pepo.demo.worker.consumer;

import com.pepo.demo.worker.config.RabbitConfig;
import com.pepo.demo.worker.events.UserCreatedEvent;
import com.pepo.demo.worker.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedConsumer {

    private final EmailService emailService;

    public UserCreatedConsumer(EmailService emailService){
        this.emailService = emailService;
    }

    @RabbitListener(queues = RabbitConfig.USER_CREATED_QUEUE)
    public void onUserCreated(UserCreatedEvent event){
        System.out.println("Worker Recebeu UserCreatedEvent");

        emailService.sendWelcomeEmail(event.getEmail());

        System.out.println("Email enviado para " + event.getEmail());

    }
}
