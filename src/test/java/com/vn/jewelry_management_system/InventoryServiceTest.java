package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Inventory;
import com.vn.jewelry_management_system.domain.InventoryId;
import com.vn.jewelry_management_system.repository.InventoryRepository;
import com.vn.jewelry_management_system.service.InventoryService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    @Test
    public void testGetAllInventories() {
        Inventory inventory1 = new Inventory();
        Inventory inventory2 = new Inventory();
        List<Inventory> inventories = Arrays.asList(inventory1, inventory2);

        when(inventoryRepository.findAll()).thenReturn(inventories);

        List<Inventory> result = inventoryService.getAllInventories();
        assertEquals(2, result.size());
        verify(inventoryRepository, times(1)).findAll();
    }

    @Test
    public void testGetInventoryById() {
        InventoryId id = new InventoryId(1, 1);
        Inventory inventory = new Inventory();
        when(inventoryRepository.findById(id)).thenReturn(Optional.of(inventory));

        Optional<Inventory> result = inventoryService.getInventoryById(id);
        assertTrue(result.isPresent());
        verify(inventoryRepository, times(1)).findById(id);
    }

    @Test
    public void testSaveInventory() {
        Inventory inventory = new Inventory();
        when(inventoryRepository.save(inventory)).thenReturn(inventory);

        Inventory result = inventoryService.saveInventory(inventory);
        assertNotNull(result);
        verify(inventoryRepository, times(1)).save(inventory);
    }

    @Test
    public void testDeleteInventory() {
        InventoryId id = new InventoryId(1, 1);
        doNothing().when(inventoryRepository).deleteById(id);

        inventoryService.deleteInventory(id);
        verify(inventoryRepository, times(1)).deleteById(id);
    }
}