package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.StallController;
import com.vn.jewelry_management_system.domain.Stall;
import com.vn.jewelry_management_system.service.StallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StallControllerTest {

    @Mock
    private StallService stallService;

    @Mock
    private Model model;

    @InjectMocks
    private StallController stallController;

    private Stall stall;

    @BeforeEach
    public void setUp() {
        stall = new Stall();
        stall.setStallId(1);
    }

    @Test
    public void testShowAllStalls() {
        when(stallService.getAllStalls()).thenReturn(Collections.singletonList(stall));

        String viewName = stallController.showAllStalls(model);

        assertEquals("admin/stall/table-stall", viewName);
        verify(model, times(1)).addAttribute("stalls", Collections.singletonList(stall));
    }

    @Test
    public void testShowCreateForm() {
        String viewName = stallController.showCreateForm(model);
    
        assertEquals("admin/stall/create", viewName);
        verify(model, times(1)).addAttribute(eq("stall"), any(Stall.class));
    }

    @Test
    public void testCreateStall() {
        String viewName = stallController.createStall(stall);

        assertEquals("redirect:/admin/stalls", viewName);
        verify(stallService, times(1)).saveStall(stall);
    }

    @Test
    public void testShowEditForm_StallFound() {
        when(stallService.getStallById(1)).thenReturn(Optional.of(stall));

        String viewName = stallController.showEditForm(1, model);

        assertEquals("admin/stall/edit", viewName);
        verify(model, times(1)).addAttribute("stall", stall);
    }

    @Test
    public void testShowEditForm_StallNotFound() {
        when(stallService.getStallById(1)).thenReturn(Optional.empty());

        String viewName = stallController.showEditForm(1, model);

        assertEquals("admin/stall/edit", viewName);
        verify(model, times(1)).addAttribute("stall", null);
    }

    @Test
    public void testUpdateStall() {
        String viewName = stallController.updateStall(1, stall);

        assertEquals("redirect:/admin/stalls", viewName);
        verify(stallService, times(1)).saveStall(stall);
    }

    @Test
    public void testDeleteStall() {
        String viewName = stallController.deleteStall(1);

        assertEquals("redirect:/admin/stalls", viewName);
        verify(stallService, times(1)).deleteStall(1);
    }
}