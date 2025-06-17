package com.monsters.dtos.review;

import com.monsters.models.Product;
import jakarta.validation.constraints.NotBlank;

public record ReviewRequest(
        @NotBlank(message = "User name is required")
        String userName,
        double rating,
        String body,
        Long productId
) {

}
