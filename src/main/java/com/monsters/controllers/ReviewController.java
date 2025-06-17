package com.monsters.controllers;

import com.monsters.dtos.review.ReviewRequest;
import com.monsters.dtos.review.ReviewResponse;
import com.monsters.models.Product;
import com.monsters.models.Review;
import com.monsters.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.PublicKey;
import java.util.List;

@Controller
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/review")
    public ResponseEntity<List<ReviewResponse>> getAllReviewController() {
        List<ReviewResponse> reviews = reviewService.getAllReview();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<ReviewResponse> getReviewById(@PathVariable Long id) {
        ReviewResponse reviewResponse = reviewService.getReviewById(id);
        return  new ResponseEntity<>(reviewResponse, HttpStatus.OK);
    }

    @PostMapping("/review")
    public ResponseEntity<ReviewResponse> addReview(@RequestBody ReviewRequest reviewRequest, Product product) {
        ReviewResponse addedReview = reviewService.addReview(reviewRequest, product);
        return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
    }

}
