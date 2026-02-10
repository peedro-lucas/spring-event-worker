package com.pepo.demo.worker.domain;


import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_log")
public class AuditLog {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,unique=true, length = 64)
    private String eventId;

    @Lob
    @Column()
    private String payload;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuditStatus status;

    @Column(nullable = false)
    private Instant occurredAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public AuditStatus getStatus() {
        return status;
    }

    public void setStatus(AuditStatus status) {
        this.status = status;
    }

    public Instant  getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(Instant  occurredAt) {
        this.occurredAt = occurredAt;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(LocalDateTime processedAt) {
        this.processedAt = processedAt;
    }

    @Column(nullable = false)
    private LocalDateTime processedAt;

    @PrePersist
    public void prePersist(){
        this.processedAt = LocalDateTime.now();

    }
}

