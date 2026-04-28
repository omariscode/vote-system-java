package com.omarscode.voting_system.category.dto;

import com.omarscode.voting_system.activity.entity.Activity;
import com.omarscode.voting_system.category.entity.CategoryType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCategoryDTO (
    @NotBlank String name,
    @NotNull CategoryType categoryType,
    @NotNull Activity activity

) {}
