package com.omarscode.voting_system.activity.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.omarscode.voting_system.category.entity.Category;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

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

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> categories = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Activity() {
    }

    public Activity(String name, String description, boolean finished, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.description = description;
        this.finished = finished;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFinished() {
        return finished;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
