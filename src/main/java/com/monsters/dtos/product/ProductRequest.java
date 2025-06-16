package com.monsters.dtos.product;

import jakarta.validation.constraints.NotBlank;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Price is required")
        double price,
        String imageUrl,
        double rating,
        @NotBlank(message = "Availability is required")
        boolean featured
) {
}
