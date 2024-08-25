package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.InventoryController;
import com.vn.jewelry_management_system.domain.Inventory;
import com.vn.jewelry_management_system.domain.Stall;
import com.vn.jewelry_management_system.domain.Product;
import com.vn.jewelry_management_system.service.InventoryService;
import com.vn.jewelry_management_system.service.ProductService;
import com.vn.jewelry_management_system.service.StallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InventoryControllerTest {

    @Mock
    private InventoryService inventoryService;

    @Mock
    private StallService stallService;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private InventoryController inventoryController;

    private List<Inventory> sampleInventories;
    private List<Stall> sampleStalls;
    private List<Product> sampleProducts;

    @BeforeEach
    public void setUp() {
        sampleInventories = Collections.singletonList(new Inventory());
        sampleStalls = Collections.singletonList(new Stall());
        sampleProducts = Collections.singletonList(new Product());
    }

    @Test
    public void testShowAllInventories() {
        when(inventoryService.getAllInventories()).thenReturn(sampleInventories);
        when(stallService.getAllStalls()).thenReturn(sampleStalls);
        when(productService.getAllProducts()).thenReturn(sampleProducts);

        String viewName = inventoryController.showAllInventories(model);

        assertEquals("admin/inventory/table-inventory", viewName);
        verify(model, times(1)).addAttribute("inventories", sampleInventories);
        verify(model, times(1)).addAttribute("stalls", sampleStalls);
        verify(model, times(1)).addAttribute("products", sampleProducts);
    }
}