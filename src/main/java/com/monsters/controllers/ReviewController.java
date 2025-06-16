package com.monsters.controllers;

import com.monsters.models.Review;
import com.monsters.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/review")
    public ResponseEntity<List<Review>> getAllReviewController() {
        List<Review> reviews = reviewService.getAllReviewService();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
