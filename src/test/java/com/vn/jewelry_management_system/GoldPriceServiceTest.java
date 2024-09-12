package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.GoldPrice;
import com.vn.jewelry_management_system.repository.GoldPriceRepository;
import com.vn.jewelry_management_system.service.GoldPriceService;
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

public class GoldPriceServiceTest {

    @Mock
    private GoldPriceRepository goldPriceRepository;

    @InjectMocks
    private GoldPriceService goldPriceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetLatestBuyingPrice() {
        BigDecimal buyingPrice = new BigDecimal("1500.00");
        when(goldPriceRepository.findLatestBuyingPrice()).thenReturn(Optional.of(buyingPrice));

        BigDecimal result = goldPriceService.getLatestBuyingPrice();
        assertEquals(buyingPrice, result);
    }

    @Test
    public void testGetLatestBuyingPrice_NotFound() {
        when(goldPriceRepository.findLatestBuyingPrice()).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            goldPriceService.getLatestBuyingPrice();
        });

        assertEquals("Không tìm thấy giá mua mới nhất!", exception.getMessage());
    }

    @Test
    public void testGetLatestSellingPrice() {
        BigDecimal sellingPrice = new BigDecimal("1600.00");
        when(goldPriceRepository.findLatestSellingPrice()).thenReturn(Optional.of(sellingPrice));

        BigDecimal result = goldPriceService.getLatestSellingPrice();
        assertEquals(sellingPrice, result);
    }

    @Test
    public void testGetLatestSellingPrice_NotFound() {
        when(goldPriceRepository.findLatestSellingPrice()).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            goldPriceService.getLatestSellingPrice();
        });

        assertEquals("Không tìm thấy giá bán mới nhất!", exception.getMessage());
    }

    @Test
    public void testGetAllGoldPrices() {
        GoldPrice goldPrice1 = new GoldPrice();
        GoldPrice goldPrice2 = new GoldPrice();
        List<GoldPrice> goldPrices = Arrays.asList(goldPrice1, goldPrice2);

        when(goldPriceRepository.findAll()).thenReturn(goldPrices);

        List<GoldPrice> result = goldPriceService.getAllGoldPrices();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetGoldPriceById() {
        GoldPrice goldPrice = new GoldPrice();
        when(goldPriceRepository.findById(1)).thenReturn(Optional.of(goldPrice));

        Optional<GoldPrice> result = goldPriceService.getGoldPriceById(1);
        assertTrue(result.isPresent());
        assertEquals(goldPrice, result.get());
    }

    @Test
    public void testSaveGoldPrice() {
        GoldPrice goldPrice = new GoldPrice();
        when(goldPriceRepository.save(goldPrice)).thenReturn(goldPrice);

        GoldPrice result = goldPriceService.saveGoldPrice(goldPrice);
        assertEquals(goldPrice, result);
    }

    @Test
    public void testDeleteGoldPrice() {
        doNothing().when(goldPriceRepository).deleteById(1);

        goldPriceService.deleteGoldPrice(1);
        verify(goldPriceRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFindByUpdateDate() {
        Date updateDate = new Date();
        GoldPrice goldPrice = new GoldPrice();
        when(goldPriceRepository.findByUpdateDate(updateDate)).thenReturn(Optional.of(goldPrice));

        Optional<GoldPrice> result = goldPriceService.findByUpdateDate(updateDate);
        assertTrue(result.isPresent());
        assertEquals(goldPrice, result.get());
    }
}