package com.sakamoto.feed.core.port.in.rest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PostCommand(@NotBlank String title, @NotBlank String description, @Min(0) @Max(100_000) double price,
                          Long userId, Long petId) {
}
