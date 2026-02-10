package com.pepo.demo.worker.events;

import java.time.Instant;

public class UserCreatedEvent {


    private String eventId;
    private Long userId;
    private String email;
    private Instant occuredAt;

    public UserCreatedEvent (){}

    public String getEventId() {return eventId;}

    public Instant getOccuredAt() {return occuredAt;}

    public String getEmail() {return email;}

    public Long getUserId() {return userId;}

}
