package com.omarscode.voting_system.category.entity;

import com.omarscode.voting_system.activity.entity.Activity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    public Category() {
    }

    public Category(String name, CategoryType categoryType, Activity activity) {
        this.name = name;
        this.categoryType = categoryType;
        this.activity = activity;
    }

    public Long geId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public CategoryType getType(){
        return categoryType;
    }

    public Activity getActivity(){
        return activity;
    }
}
