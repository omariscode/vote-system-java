package com.omarscode.voting_system.Subcategory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long>{
    List<Subcategory> findByCategoryId(Long categoryId);
}
