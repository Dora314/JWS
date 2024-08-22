package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.ProductType;
import com.vn.jewelry_management_system.repository.ProductTypeRepository;
import com.vn.jewelry_management_system.service.ProductTypeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductTypeServiceTest {

    @Mock
    private ProductTypeRepository productTypeRepository;

    @InjectMocks
    private ProductTypeService productTypeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProductTypes() {
        // Arrange
        ProductType productType1 = new ProductType("Type A");
        ProductType productType2 = new ProductType("Type B");
        List<ProductType> productTypeList = Arrays.asList(productType1, productType2);
        when(productTypeRepository.findAll()).thenReturn(productTypeList);

        // Act
        List<ProductType> result = productTypeService.getAllProductTypes();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Type A", result.get(0).getProductTypeName());
        assertEquals("Type B", result.get(1).getProductTypeName());
    }

    @Test
    public void testGetProductTypeById() {
        // Arrange
        ProductType productType = new ProductType("Type A");
        when(productTypeRepository.findById(1)).thenReturn(Optional.of(productType));

        // Act
        Optional<ProductType> result = productTypeService.getProductTypeById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Type A", result.get().getProductTypeName());
    }

    @Test
    public void testSaveProductType() {
        // Arrange
        ProductType productType = new ProductType("Type A");
        when(productTypeRepository.save(productType)).thenReturn(productType);

        // Act
        ProductType result = productTypeService.saveProductType(productType);

        // Assert
        assertNotNull(result);
        assertEquals("Type A", result.getProductTypeName());
    }

    @Test
    public void testDeleteProductType() {
        // Act
        productTypeService.deleteProductType(1);

        // Assert
        verify(productTypeRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFindByProductTypeName() {
        // Arrange
        ProductType productType = new ProductType("Type A");
        when(productTypeRepository.findByProductTypeName("Type A")).thenReturn(Optional.of(productType));

        // Act
        Optional<ProductType> result = productTypeService.findByProductTypeName("Type A");

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Type A", result.get().getProductTypeName());
    }
}