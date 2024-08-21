package com.vn.jewelry_management_system.service;

import org.springframework.stereotype.Service;
import com.vn.jewelry_management_system.domain.Product;
import com.vn.jewelry_management_system.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }
}