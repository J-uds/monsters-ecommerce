package com.monsters.dtos.review;


import com.monsters.models.Product;
import com.monsters.models.Review;

public class ReviewMapper {
    public static Review dtoToEntity(ReviewRequest dto, Product product) {
        return new Review(
                dto.userName(),
                dto.rating(),
                dto.body(),
                product
        );
    }

    public static ReviewResponse entityToDto(Review review) {
        return new ReviewResponse(
                review.getUserName(),
                review.getRating(),
                review.getBody()
        );
    }
}
