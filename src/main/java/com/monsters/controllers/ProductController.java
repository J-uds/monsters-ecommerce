package com.monsters.controllers;

import com.monsters.dtos.product.ProductRequest;
import com.monsters.dtos.product.ProductResponse;
import com.monsters.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    /*public ResponseEntity<List<ProductResponse>> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }*/
    public ResponseEntity<List<ProductResponse>> getAllProduct() {
        List<ProductResponse> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        ProductResponse gotProduct = productService.getProductById(id);
        return new ResponseEntity<>(gotProduct, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse addedProduct = productService.addProduct(productRequest);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductResponse> deleteProductById(@PathVariable Long id) {
        ProductResponse deletedProduct = productService.getProductById(id);
        productService.deleteProductById(id);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponse> updateProductById(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        ProductResponse updatedProduct = productService.updateProductById(id, productRequest);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }






}
