package com.omarscode.voting_system.category.dto;

import com.omarscode.voting_system.activity.entity.Activity;
import com.omarscode.voting_system.category.entity.CategoryType;

public record CategoryResponseDTO(
    Long id,
    String name,
    CategoryType categoryType,
    Activity activity
) {}