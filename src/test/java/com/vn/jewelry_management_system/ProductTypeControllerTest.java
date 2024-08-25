package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.ProductTypeController;
import com.vn.jewelry_management_system.domain.ProductType;
import com.vn.jewelry_management_system.service.ProductTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductTypeControllerTest {

    @Mock
    private ProductTypeService productTypeService;

    @InjectMocks
    private ProductTypeController productTypeController;

    private ProductType productType;

    @BeforeEach
    public void setUp() {
        productType = new ProductType();
        productType.setProductTypeId(1);
        productType.setProductTypeName("Ring");
    }

    @Test
    public void testUpdateProductType_Success() {
        // Arrange
        when(productTypeService.saveProductType(any(ProductType.class))).thenReturn(productType);

        // Act
        String viewName = productTypeController.updateProductType(1, productType);

        // Assert
        verify(productTypeService, times(1)).saveProductType(productType);
        assertEquals("redirect:/admin/product-types", viewName);
    }

    @Test
    public void testUpdateProductType_ProductTypeNotFound() {
        // Arrange
        when(productTypeService.saveProductType(any(ProductType.class))).thenReturn(null);

        // Act
        String viewName = productTypeController.updateProductType(1, productType);

        // Assert
        verify(productTypeService, times(1)).saveProductType(productType);
        assertEquals("redirect:/admin/product-types", viewName);
    }
}