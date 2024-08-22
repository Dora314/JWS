package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Promotion;
import com.vn.jewelry_management_system.repository.PromotionRepository;
import com.vn.jewelry_management_system.service.PromotionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PromotionServiceTest {

    @Mock
    private PromotionRepository promotionRepository;

    @InjectMocks
    private PromotionService promotionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPromotions() {
        // Arrange
        Promotion promotion1 = new Promotion(
            "Promotion A",          // promotionName
            "Discount",             // promotionType
            "CDT123",               // cdt
            new BigDecimal("20.00"),// value
            new Date(),             // startDate
            new Date()              // endDate
        );
        Promotion promotion2 = new Promotion(
            "Promotion B",          // promotionName
            "Discount",             // promotionType
            "CDT123",               // cdt
            new BigDecimal("20.00"),// value
            new Date(),             // startDate
            new Date()              // endDate
        );
        List<Promotion> promotionList = Arrays.asList(promotion1, promotion2);
        when(promotionRepository.findAll()).thenReturn(promotionList);

        // Act
        List<Promotion> result = promotionService.getAllPromotions();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Promotion A", result.get(0).getPromotionName());
        assertEquals("Promotion B", result.get(1).getPromotionName());
    }

    @Test
    public void testGetPromotionById() {
        // Arrange
        Promotion promotion = new Promotion(
            "Promotion A",          // promotionName
            "Discount",             // promotionType
            "CDT123",               // cdt
            new BigDecimal("20.00"),// value
            new Date(),             // startDate
            new Date()              // endDate
        );
        when(promotionRepository.findById(1)).thenReturn(Optional.of(promotion));

        // Act
        Optional<Promotion> result = promotionService.getPromotionById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Promotion A", result.get().getPromotionName());
    }

    @Test
    public void testSavePromotion() {
        // Arrange
        Promotion promotion = new Promotion(
            "Promotion A",          // promotionName
            "Discount",             // promotionType
            "CDT123",               // cdt
            new BigDecimal("20.00"),// value
            new Date(),             // startDate
            new Date()              // endDate
        );
        when(promotionRepository.save(promotion)).thenReturn(promotion);

        // Act
        Promotion result = promotionService.savePromotion(promotion);

        // Assert
        assertNotNull(result);
        assertEquals("Promotion A", result.getPromotionName());
    }

    @Test
    public void testDeletePromotion() {
        // Act
        promotionService.deletePromotion(1);

        // Assert
        verify(promotionRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFindByPromotionName() {
        // Arrange
        Promotion promotion = new Promotion(
            "Promotion A",          // promotionName
            "Discount",             // promotionType
            "CDT123",               // cdt
            new BigDecimal("20.00"),// value
            new Date(),             // startDate
            new Date()              // endDate
        );
        when(promotionRepository.findByPromotionName("Promotion A")).thenReturn(Optional.of(promotion));

        // Act
        Optional<Promotion> result = promotionService.findByPromotionName("Promotion A");

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Promotion A", result.get().getPromotionName());
    }
}