package com.monsters.dtos.review;

public record ReviewResponse(
        String userName,
        double rating,
        String body
) {

}
