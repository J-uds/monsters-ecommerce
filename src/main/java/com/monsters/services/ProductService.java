package com.monsters.services;

import com.monsters.models.Product;
import com.monsters.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getByIdProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public Product addProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    /*public Product updateProductById(Long id, Product updatedProduct) {
        Product toUpdateProduct = getByIdProduct(id);
        toUpdateProduct.setName(updatedProduct.getName());
        toUpdateProduct.setPrice(updatedProduct.getPrice());
        toUpdateProduct.setImageUrl(updatedProduct.getImageUrl());
        toUpdateProduct.setRating(updatedProduct.getRating());
        toUpdateProduct.setReviewCount(updatedProduct.getReviewCount());

        return productRepository.save(toUpdateProduct);
    }*/
}
