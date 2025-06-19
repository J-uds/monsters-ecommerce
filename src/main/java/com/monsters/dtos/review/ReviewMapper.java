package com.monsters.dtos.review;


import com.monsters.models.Product;
import com.monsters.models.Review;

public class ReviewMapper {
    public static Review dtoToEntity(ReviewRequest dto, Product product) {
        return new Review(
                dto.username(),
                dto.rating(),
                dto.body(),
                product
        );
    }

    public static ReviewResponse entityToDto(Review review) {
        return new ReviewResponse(
                review.getUsername(),
                review.getRating(),
                review.getBody()
        );
    }
}
