package com.omarscode.voting_system.activity.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateActivityDTO(
    @NotBlank String name,
    @NotBlank String description,
    boolean finished,
    @NotNull LocalDate startDate,
    @NotNull LocalDate endDate
) {}