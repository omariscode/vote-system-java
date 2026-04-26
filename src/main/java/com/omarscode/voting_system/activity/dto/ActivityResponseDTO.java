package com.omarscode.voting_system.activity.dto;

import java.time.LocalDate;

public record ActivityResponseDTO (
    String name,
    String description,
    boolean finished,
    LocalDate startDate,
    LocalDate endDate
) {}
