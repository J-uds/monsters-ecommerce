package com.monsters.dtos.product;

import com.monsters.dtos.review.ReviewResponse;

import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        double price,
        String imageUrl,
        double rating,
        int reviewCount,
        boolean featured,
        List<ReviewResponse> reviews
) {

}
