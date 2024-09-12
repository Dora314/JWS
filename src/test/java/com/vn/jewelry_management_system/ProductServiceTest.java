package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Product;
import com.vn.jewelry_management_system.repository.ProductRepository;
import com.vn.jewelry_management_system.service.GoldPriceService;
import com.vn.jewelry_management_system.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private GoldPriceService goldPriceService;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateSellingPrice() {
        Product product = new Product();
        product.setWeight(new BigDecimal("10"));
        product.setMakingFee(new BigDecimal("100"));
        product.setGemstonePrice(new BigDecimal("200"));
        product.setMarkupRatio(new BigDecimal("0.2"));

        when(goldPriceService.getLatestSellingPrice()).thenReturn(new BigDecimal("50"));

        BigDecimal sellingPrice = productService.calculateSellingPrice(product);

        BigDecimal expectedCostPrice = new BigDecimal("50").multiply(new BigDecimal("10"))
                .add(new BigDecimal("100"))
                .add(new BigDecimal("200"));
        BigDecimal expectedSellingPrice = expectedCostPrice.multiply(new BigDecimal("1.2"));

        assertEquals(expectedSellingPrice, sellingPrice);
    }

    @Test
    public void testCalculateBuybackPrice() {
        Product product = new Product();
        product.setWeight(new BigDecimal("10"));
        product.setMakingFee(new BigDecimal("100"));
        product.setGemstonePrice(new BigDecimal("200"));

        when(goldPriceService.getLatestBuyingPrice()).thenReturn(new BigDecimal("50"));

        BigDecimal buybackPrice = productService.calculateBuybackPrice(product);

        BigDecimal expectedCostPrice = new BigDecimal("50").multiply(new BigDecimal("10"))
                .add(new BigDecimal("100"))
                .add(new BigDecimal("200"));
        BigDecimal expectedBuybackPrice = expectedCostPrice.multiply(new BigDecimal("0.9"));

        assertEquals(expectedBuybackPrice, buybackPrice);
    }

    @Test
    public void testGetAllProducts() {
        productService.getAllProducts();
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testGetProductById() {
        int productId = 1;
        productService.getProductById(productId);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        productService.saveProduct(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testDeleteProduct() {
        int productId = 1;
        productService.deleteProduct(productId);
        verify(productRepository, times(1)).deleteById(productId);
    }

    @Test
    public void testFindByProductName() {
        String productName = "Ring";
        productService.findByProductName(productName);
        verify(productRepository, times(1)).findByProductName(productName);
    }
}