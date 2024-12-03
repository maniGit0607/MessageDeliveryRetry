package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FailedMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private int retryCount;
}
