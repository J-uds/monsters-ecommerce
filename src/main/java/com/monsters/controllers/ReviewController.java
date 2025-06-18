package com.monsters.controllers;

import com.monsters.dtos.review.ReviewRequest;
import com.monsters.dtos.review.ReviewResponse;
import com.monsters.models.Product;
import com.monsters.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/review/{productId}")
    public ResponseEntity<List<ReviewResponse>> getAllProductReviews(@PathVariable Long productId) {
        List<ReviewResponse> reviews = reviewService.getAllProductReviews(productId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping("/review")
    public ResponseEntity<ReviewResponse> addReview(@RequestBody ReviewRequest reviewRequest, Product product) {
        ReviewResponse addedReview = reviewService.addReview(reviewRequest);
        return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
    }
}
