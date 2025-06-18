package com.monsters.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    @Column(name = "image_Url")
    private String imageUrl;
    private double rating;
    @Column(name = "review_count")
    private int reviewCount;
    private boolean featured;

    @OneToMany(targetEntity = Review.class, fetch = FetchType.LAZY, mappedBy = "product")
    private List<Review> reviews;

    public Product() {
    }

    public Product(String name, double price, String imageUrl, boolean featured) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating = 0.0;
        this.reviewCount = 0;
        this.featured = featured;
        this.reviews = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
