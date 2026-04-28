package com.omarscode.voting_system.Subcategory;


import com.omarscode.voting_system.category.entity.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Subcategory {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Subcategory() {
    }

    public Subcategory(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Category getCategory(){
        return category;
    }
}