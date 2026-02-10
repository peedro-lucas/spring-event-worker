package com.pepo.demo.worker.consumer;


import com.pepo.demo.worker.config.RabbitConfig;
import com.pepo.demo.worker.events.UserCreatedEvent;
import com.pepo.demo.worker.service.AuditService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedAuditConsumer {

    private final AuditService auditService;

    public UserCreatedAuditConsumer (AuditService auditService){
        this.auditService = auditService;
    }
    
    
    @RabbitListener(queues = RabbitConfig.USER_CREATED_AUDIT_QUEUE)
    public void onUserCreatedAudit(UserCreatedEvent event){
        auditService.saveUserCreated(event);
        System.out.println("Audit recebeu  eventId " +event.getEventId() );
    }
}
