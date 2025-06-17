package com.monsters.services;

import com.monsters.dtos.review.ReviewMapper;
import com.monsters.dtos.review.ReviewRequest;
import com.monsters.dtos.review.ReviewResponse;
import com.monsters.models.Product;
import com.monsters.models.Review;
import com.monsters.repositories.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ReviewResponse> getAllReview() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(review -> ReviewMapper.entityToDto(review)).toList();
    }

    public ReviewResponse getReviewById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found"));
        return ReviewMapper.entityToDto(review);
    }

    public ReviewResponse addReview(ReviewRequest newReviewRequest, Product product) {
        Review newReview = ReviewMapper.dtoToEntity(newReviewRequest, product);
        Review savedNewReview = reviewRepository.save(newReview);
        return ReviewMapper.entityToDto(savedNewReview);
    }
}
