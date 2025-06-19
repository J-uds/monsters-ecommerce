package com.monsters.dtos.product;

import com.monsters.dtos.review.ReviewMapper;
import com.monsters.dtos.review.ReviewResponse;
import com.monsters.models.Product;

import java.util.List;
import java.util.stream.Collectors;


public class ProductMapper {
    public static Product dtoToEntity(ProductRequest dto) {
        return new Product(
                dto.name(),
                dto.price(),
                dto.imageUrl(),
                dto.featured());
    }

    public static ProductResponse entityToDto(Product product) {
        List<ReviewResponse> reviews = product.getReviews() != null ? product.getReviews().stream().map(ReviewMapper::entityToDto).collect(Collectors.toList()) : List.of();

        return new ProductResponse(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImageUrl(),
                product.getRating(),
                product.getReviewCount(),
                product.isFeatured(),
                reviews);
    }
}
