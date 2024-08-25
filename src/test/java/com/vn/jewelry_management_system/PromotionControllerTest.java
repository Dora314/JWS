package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.PromotionController;
import com.vn.jewelry_management_system.domain.Promotion;
import com.vn.jewelry_management_system.service.PromotionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PromotionControllerTest {

    @Mock
    private PromotionService promotionService;

    @Mock
    private Model model;

    @InjectMocks
    private PromotionController promotionController;

    private Promotion promotion;

    @BeforeEach
    public void setUp() {
        promotion = new Promotion();
        promotion.setPromotionId(1);
    }

    @Test
    public void testShowAllPromotions() {
        when(promotionService.getAllPromotions()).thenReturn(Collections.singletonList(promotion));

        String viewName = promotionController.showAllPromotions(model);

        assertEquals("admin/promotion/table-promotion", viewName);
        verify(model, times(1)).addAttribute("promotions", Collections.singletonList(promotion));
    }

    @Test
    public void testShowCreateForm() {
        // Act
        String viewName = promotionController.showCreateForm(model);

        // Assert
        assertEquals("admin/promotion/create", viewName);

        ArgumentCaptor<Promotion> promotionCaptor = ArgumentCaptor.forClass(Promotion.class);
        verify(model, times(1)).addAttribute(eq("promotion"), promotionCaptor.capture());

        Promotion capturedPromotion = promotionCaptor.getValue();
        assertEquals(0, capturedPromotion.getPromotionId());
        assertEquals(null, capturedPromotion.getPromotionName());
        assertEquals(null, capturedPromotion.getPromotionType());
        assertEquals(null, capturedPromotion.getCdt());
        assertEquals(null, capturedPromotion.getValue());
        assertEquals(null, capturedPromotion.getStartDate());
        assertEquals(null, capturedPromotion.getEndDate());
    }

    @Test
    public void testCreatePromotion() {
        String viewName = promotionController.createPromotion(promotion);

        verify(promotionService, times(1)).savePromotion(promotion);
        assertEquals("redirect:/admin/promotions", viewName);
    }

    @Test
    public void testShowEditForm_PromotionFound() {
        when(promotionService.getPromotionById(1)).thenReturn(Optional.of(promotion));

        String viewName = promotionController.showEditForm(1, model);

        assertEquals("admin/promotion/edit", viewName);
        verify(model, times(1)).addAttribute("promotion", promotion);
    }

    @Test
    public void testShowEditForm_PromotionNotFound() {
        when(promotionService.getPromotionById(1)).thenReturn(Optional.empty());

        String viewName = promotionController.showEditForm(1, model);

        assertEquals("admin/promotion/edit", viewName);
        verify(model, times(1)).addAttribute("promotion", null);
    }

    @Test
    public void testUpdatePromotion() {
        String viewName = promotionController.updatePromotion(1, promotion);

        verify(promotionService, times(1)).savePromotion(promotion);
        assertEquals("redirect:/admin/promotions", viewName);
    }

    @Test
    public void testDeletePromotion() {
        String viewName = promotionController.deletePromotion(1);

        verify(promotionService, times(1)).deletePromotion(1);
        assertEquals("redirect:/admin/promotions", viewName);
    }
}