package com.omarscode.voting_system.Subcategory.dto;

import com.omarscode.voting_system.category.entity.Category;

public record SubcategoryResponseDTO (
    Long id,
    String name,
    Category category
) {}
