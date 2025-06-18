package com.monsters.dtos.review;

import jakarta.validation.constraints.NotBlank;

public record ReviewRequest(
        @NotBlank(message = "User name is required")
        String userName,
        double rating,
        String body,
        Long productId
) {

}
