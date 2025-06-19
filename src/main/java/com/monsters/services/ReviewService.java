package com.monsters.services;

import com.monsters.dtos.review.ReviewMapper;
import com.monsters.dtos.review.ReviewRequest;
import com.monsters.dtos.review.ReviewResponse;
import com.monsters.models.Product;
import com.monsters.models.Review;
import com.monsters.repositories.ReviewRepository;
import com.monsters.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

   /* public List<ReviewResponse> getAllReview() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(review -> ReviewMapper.entityToDto(review)).toList();
    }

    public ReviewResponse getReviewById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found"));
        return ReviewMapper.entityToDto(review);
    }*/

//Forma más corta y fácil de acceder a las reviews de cada producto:
   /* public List<ReviewResponse> getReviewsByProductId(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product not found"));
        return product.getReviews().stream().map(review -> ReviewMapper.entityToDto(review)).toList();
    }*/

    public List<ReviewResponse> getAllProductReviews(Long productId) {
        List<Review> reviews = reviewRepository.findAllByProductId(productId);
        if (reviews.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No reviews found for this product");
        }
        return reviews.stream().map(review -> ReviewMapper.entityToDto(review)).collect(Collectors.toList());
    }

    public ReviewResponse addReview(ReviewRequest newReviewRequest) {
        Product product = productRepository.findById(newReviewRequest.productId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        Review newReview = ReviewMapper.dtoToEntity(newReviewRequest, product);
        Review savedNewReview = reviewRepository.save(newReview);
        return ReviewMapper.entityToDto(savedNewReview);
    }
}
