package com.monsters.dtos.review;

public record ReviewResponse(
        String username,
        double rating,
        String body
) {

}
