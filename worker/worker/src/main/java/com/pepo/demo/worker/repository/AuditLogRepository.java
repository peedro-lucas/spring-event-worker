package com.pepo.demo.worker.repository;

import com.pepo.demo.worker.domain.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    boolean existsByEventId(String eventId);

    Optional<AuditLog> findByEventId(String eventId);

}
