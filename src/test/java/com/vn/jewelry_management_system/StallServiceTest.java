package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Stall;
import com.vn.jewelry_management_system.repository.StallRepository;
import com.vn.jewelry_management_system.service.StallService;
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

public class StallServiceTest {

    @Mock
    private StallRepository stallRepository;

    @InjectMocks
    private StallService stallService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStalls() {
        Stall stall1 = new Stall();
        Stall stall2 = new Stall();
        List<Stall> stalls = Arrays.asList(stall1, stall2);

        when(stallRepository.findAll()).thenReturn(stalls);

        List<Stall> result = stallService.getAllStalls();
        assertEquals(2, result.size());
        verify(stallRepository, times(1)).findAll();
    }

    @Test
    public void testGetStallById() {
        Stall stall = new Stall();
        when(stallRepository.findById(1)).thenReturn(Optional.of(stall));

        Optional<Stall> result = stallService.getStallById(1);
        assertTrue(result.isPresent());
        assertEquals(stall, result.get());
        verify(stallRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveStall() {
        Stall stall = new Stall();
        when(stallRepository.save(stall)).thenReturn(stall);

        Stall result = stallService.saveStall(stall);
        assertEquals(stall, result);
        verify(stallRepository, times(1)).save(stall);
    }

    @Test
    public void testDeleteStall() {
        doNothing().when(stallRepository).deleteById(1);

        stallService.deleteStall(1);
        verify(stallRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFindByStallName() {
        Stall stall = new Stall();
        when(stallRepository.findByStallName("Test Stall")).thenReturn(Optional.of(stall));

        Optional<Stall> result = stallService.findByStallName("Test Stall");
        assertTrue(result.isPresent());
        assertEquals(stall, result.get());
        verify(stallRepository, times(1)).findByStallName("Test Stall");
    }
}