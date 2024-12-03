package org.example.repository;

import org.example.entity.FailedMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FailedMessageRepository extends JpaRepository<FailedMessage, Long> {
}
