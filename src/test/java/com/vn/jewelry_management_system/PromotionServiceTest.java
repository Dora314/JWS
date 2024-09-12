package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Promotion;
import com.vn.jewelry_management_system.repository.PromotionRepository;
import com.vn.jewelry_management_system.service.PromotionService;
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
        Promotion promotion1 = new Promotion();
        Promotion promotion2 = new Promotion();
        List<Promotion> promotions = Arrays.asList(promotion1, promotion2);

        when(promotionRepository.findAll()).thenReturn(promotions);

        List<Promotion> result = promotionService.getAllPromotions();
        assertEquals(2, result.size());
        verify(promotionRepository, times(1)).findAll();
    }

    @Test
    public void testGetPromotionById() {
        Promotion promotion = new Promotion();
        when(promotionRepository.findById(1)).thenReturn(Optional.of(promotion));

        Optional<Promotion> result = promotionService.getPromotionById(1);
        assertTrue(result.isPresent());
        assertEquals(promotion, result.get());
        verify(promotionRepository, times(1)).findById(1);
    }

    @Test
    public void testSavePromotion() {
        Promotion promotion = new Promotion();
        when(promotionRepository.save(promotion)).thenReturn(promotion);

        Promotion result = promotionService.savePromotion(promotion);
        assertEquals(promotion, result);
        verify(promotionRepository, times(1)).save(promotion);
    }

    @Test
    public void testDeletePromotion() {
        doNothing().when(promotionRepository).deleteById(1);

        promotionService.deletePromotion(1);
        verify(promotionRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFindByPromotionName() {
        Promotion promotion = new Promotion();
        when(promotionRepository.findByPromotionName("Promo1")).thenReturn(Optional.of(promotion));

        Optional<Promotion> result = promotionService.findByPromotionName("Promo1");
        assertTrue(result.isPresent());
        assertEquals(promotion, result.get());
        verify(promotionRepository, times(1)).findByPromotionName("Promo1");
    }
}