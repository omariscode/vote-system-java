package com.omarscode.voting_system.category.entity;

import com.omarscode.voting_system.activity.entity.Activity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Activity activity;

    @ManyToOne
    private Category category;
}
