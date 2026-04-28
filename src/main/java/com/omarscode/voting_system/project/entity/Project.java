package com.omarscode.voting_system.project.entity;

import com.omarscode.voting_system.category.entity.Category;

import com.omarscode.voting_system.activity.entity.Activity;
import com.omarscode.voting_system.category.entity.Subcategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Activity activity;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Subcategory subcategory;

    public Project() {
    }
}
