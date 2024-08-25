package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.GoldPriceController;
import com.vn.jewelry_management_system.domain.GoldPrice;
import com.vn.jewelry_management_system.service.GoldPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GoldPriceControllerTest {

    @Mock
    private GoldPriceService goldPriceService;

    @Mock
    private Model model;

    @InjectMocks
    private GoldPriceController goldPriceController;

    private GoldPrice goldPrice;

    @BeforeEach
    public void setUp() {
        goldPrice = new GoldPrice();
        goldPrice.setGoldPriceId(1);
        goldPrice.setUpdateDate(new Date());
        goldPrice.setBuyingPrice(BigDecimal.valueOf(1000));
        goldPrice.setSellingPrice(BigDecimal.valueOf(1100));
    }

    @Test
    public void testUpdateGoldPrice_Success() {
        // Arrange
        int id = 1;
        when(goldPriceService.saveGoldPrice(any(GoldPrice.class))).thenReturn(goldPrice);

        // Act
        String viewName = goldPriceController.updateGoldPrice(id, goldPrice);

        // Assert
        assertEquals("redirect:/admin/gold-prices", viewName);
        verify(goldPriceService, times(1)).saveGoldPrice(goldPrice);
        assertEquals(id, goldPrice.getGoldPriceId());
    }

    @Test
    public void testUpdateGoldPrice_Failure() {
        // Arrange
        int id = 1;
        doThrow(new RuntimeException("Error saving gold price")).when(goldPriceService).saveGoldPrice(any(GoldPrice.class));

        // Act & Assert
        try {
            goldPriceController.updateGoldPrice(id, goldPrice);
        } catch (RuntimeException e) {
            assertEquals("Error saving gold price", e.getMessage());
        }

        verify(goldPriceService, times(1)).saveGoldPrice(goldPrice);
    }
}