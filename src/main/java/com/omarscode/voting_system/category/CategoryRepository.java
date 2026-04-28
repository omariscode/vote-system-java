package com.omarscode.voting_system.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omarscode.voting_system.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long > {
    List<Category> findByActivityId(Long activityId);    
}
