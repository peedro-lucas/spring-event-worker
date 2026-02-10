package com.pepo.demo.backend.events;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class UserCreatedEvent {

    private String eventId;
    private Long userId;
    private String email;
    private Instant occuredAt;

    public UserCreatedEvent(){}

    public UserCreatedEvent(Long userId,String email){
        this.eventId = UUID.randomUUID().toString();
        this.userId = userId;
        this.email = email;
        this.occuredAt = Instant.now();
    }
    public String getEventId() {
        return eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public Instant getOccuredAt() {
        return occuredAt;
    }


}
