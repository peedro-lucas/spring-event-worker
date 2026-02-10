package com.pepo.demo.worker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pepo.demo.worker.domain.AuditLog;
import com.pepo.demo.worker.domain.AuditStatus;
import com.pepo.demo.worker.events.UserCreatedEvent;
import com.pepo.demo.worker.repository.AuditLogRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AuditService {
    private final AuditLogRepository repository;
    private final ObjectMapper objectMapper;

    public AuditService (AuditLogRepository repository, ObjectMapper objectMapper){
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public AuditLog saveUserCreated(UserCreatedEvent event){

        if(repository.existsByEventId(event.getEventId())){
            return repository.findByEventId(event.getEventId()).orElse(null);
        }

        AuditLog log = new AuditLog();
        log.setStatus(AuditStatus.RECEIVED);
        log.setOccurredAt(event.getOccuredAt());
        log.setEventId(event.getEventId());

        try{
            log.setPayload(objectMapper.writeValueAsString(event));
        }catch(JsonProcessingException e){
            log.setPayload("{\\\"error\\\":\\\"failed_to_serialize_event\\\"}");
            log.setStatus(AuditStatus.FAILED);
        }

        return repository.save(log);
    }

}
