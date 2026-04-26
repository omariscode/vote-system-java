package com.omarscode.voting_system.category.entity;

import com.omarscode.voting_system.activity.entity.Activity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    @ManyToOne
    private Activity activity;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
}
