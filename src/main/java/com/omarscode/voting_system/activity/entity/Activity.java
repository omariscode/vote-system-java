package com.omarscode.voting_system.activity.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private boolean finished;

    private LocalDate startDate;
    private LocalDate endDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Activity(String name, String description, boolean finished, LocalDate startDate, LocalDate endDate) {
    this.name = name;
    this.description = description;
    this.finished = finished;
    this.startDate = startDate;
    this.endDate = endDate;
}
    
}
