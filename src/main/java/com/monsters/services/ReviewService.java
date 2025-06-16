package com.monsters.services;

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

    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    public Review getByIdReview(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found"));
    }

    public Review addReview(Review newReview) {
        return reviewRepository.save(newReview);
    }
}
