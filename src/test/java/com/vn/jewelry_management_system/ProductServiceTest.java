package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Product;
import com.vn.jewelry_management_system.repository.ProductRepository;
import com.vn.jewelry_management_system.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        // Arrange
        Product product1 = new Product(
            "Product A", 
            new BigDecimal("5.0"), 
            "Gold", 
            new BigDecimal("150.0"), 
            new BigDecimal("200.0"), 
            new BigDecimal("350.0"), 
            new BigDecimal("1.5"), 
            "image_url", 
            true
        ); 
        Product product2 = new Product(
            "Product B", 
            new BigDecimal("5.0"), 
            "Gold", 
            new BigDecimal("150.0"), 
            new BigDecimal("200.0"), 
            new BigDecimal("350.0"), 
            new BigDecimal("1.5"), 
            "image_url", 
            true
        );
        List<Product> productList = Arrays.asList(product1, product2);
        when(productRepository.findAll()).thenReturn(productList);

        // Act
        List<Product> result = productService.getAllProducts();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Product A", result.get(0).getProductName());
        assertEquals("Product B", result.get(1).getProductName());
    }

    @Test
    public void testGetProductById() {
        // Arrange
        Product product = new Product(
            "Product A", 
            new BigDecimal("5.0"), 
            "Gold", 
            new BigDecimal("150.0"), 
            new BigDecimal("200.0"), 
            new BigDecimal("350.0"), 
            new BigDecimal("1.5"), 
            "image_url", 
            true
        );
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // Act
        Optional<Product> result = productService.getProductById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Product A", result.get().getProductName());
    }

    @Test
    public void testSaveProduct() {
        // Arrange
        Product product = new Product(
            "Product A", 
            new BigDecimal("5.0"), 
            "Gold", 
            new BigDecimal("150.0"), 
            new BigDecimal("200.0"), 
            new BigDecimal("350.0"), 
            new BigDecimal("1.5"), 
            "image_url", 
            true
        );
        when(productRepository.save(product)).thenReturn(product);

        // Act
        Product result = productService.saveProduct(product);

        // Assert
        assertNotNull(result);
        assertEquals("Product A", result.getProductName());
    }

    @Test
    public void testDeleteProduct() {
        // Act
        productService.deleteProduct(1);

        // Assert
        verify(productRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFindByProductName() {
        // Arrange
        Product product = new Product(
            "Product A", 
            new BigDecimal("5.0"), 
            "Gold", 
            new BigDecimal("150.0"), 
            new BigDecimal("200.0"), 
            new BigDecimal("350.0"), 
            new BigDecimal("1.5"), 
            "image_url", 
            true
        );
        when(productRepository.findByProductName("Product A")).thenReturn(Optional.of(product));

        // Act
        Optional<Product> result = productService.findByProductName("Product A");

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Product A", result.get().getProductName());
    }
}