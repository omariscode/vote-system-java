package com.omarscode.voting_system.Subcategory.dto;

import com.omarscode.voting_system.category.entity.Category;

import jakarta.validation.constraints.NotNull;

public record CreateSubcategoryDTO (
    @NotNull String name,
    @NotNull Category category

) {}
