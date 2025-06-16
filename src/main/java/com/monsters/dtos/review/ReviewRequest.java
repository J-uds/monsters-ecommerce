package com.monsters.dtos.review;

import com.monsters.models.Product;

public record ReviewRequest(
        String userName,
        double rating,
        String body,
        Long productId
) {

}
