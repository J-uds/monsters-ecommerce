package com.monsters.services;

import com.monsters.dtos.product.ProductMapper;
import com.monsters.dtos.product.ProductRequest;
import com.monsters.dtos.product.ProductResponse;
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

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        return ProductMapper.entityToDto(product);
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product newProduct = ProductMapper.dtoToEntity(productRequest);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.entityToDto(savedProduct);
    }

    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        productRepository.delete(product);
    }

    public ProductResponse updateProductById(Long id, ProductRequest updatedProduct) {
        Product toUpdateProduct = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        toUpdateProduct.setName(updatedProduct.name());
        toUpdateProduct.setPrice(updatedProduct.price());
        toUpdateProduct.setImageUrl(updatedProduct.imageUrl());
        toUpdateProduct.setRating(updatedProduct.rating());
        toUpdateProduct.setFeatured(updatedProduct.featured());

        Product savedProduct = productRepository.save(toUpdateProduct);

        return ProductMapper.entityToDto(savedProduct);
    }
}
