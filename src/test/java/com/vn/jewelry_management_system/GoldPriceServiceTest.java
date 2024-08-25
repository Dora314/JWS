package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.GoldPrice;
import com.vn.jewelry_management_system.repository.GoldPriceRepository;
import com.vn.jewelry_management_system.service.GoldPriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GoldPriceServiceTest {

    @Mock
    private GoldPriceRepository goldPriceRepository;

    @InjectMocks
    private GoldPriceService goldPriceService;

    @Test
    public void testGetAllGoldPrices() {
        GoldPrice price1 = new GoldPrice(new Date(), "Gold 1", BigDecimal.valueOf(100), BigDecimal.valueOf(200));
        GoldPrice price2 = new GoldPrice(new Date(), "Gold 2", BigDecimal.valueOf(200), BigDecimal.valueOf(300));
        List<GoldPrice> prices = Arrays.asList(price1, price2);

        when(goldPriceRepository.findAll()).thenReturn(prices);

        List<GoldPrice> result = goldPriceService.getAllGoldPrices();
        assertEquals(2, result.size());
        verify(goldPriceRepository, times(1)).findAll();
    }

    @Test
    public void testGetGoldPriceById() {
        GoldPrice price = new GoldPrice(new Date(), "Gold 1", BigDecimal.valueOf(100), BigDecimal.valueOf(200));
        when(goldPriceRepository.findById(1)).thenReturn(Optional.of(price));

        Optional<GoldPrice> result = goldPriceService.getGoldPriceById(1);
        assertTrue(result.isPresent());
        assertEquals(BigDecimal.valueOf(100), result.get().getBuyingPrice());
        verify(goldPriceRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveGoldPrice() {
        GoldPrice price = new GoldPrice(new Date(), "Gold 1", BigDecimal.valueOf(100), BigDecimal.valueOf(200));
        when(goldPriceRepository.save(price)).thenReturn(price);

        GoldPrice result = goldPriceService.saveGoldPrice(price);
        assertEquals(BigDecimal.valueOf(100), result.getBuyingPrice());
        verify(goldPriceRepository, times(1)).save(price);
    }

    @Test
    public void testDeleteGoldPrice() {
        doNothing().when(goldPriceRepository).deleteById(1);

        goldPriceService.deleteGoldPrice(1);
        verify(goldPriceRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFindByUpdateDate() {
        Date date = new Date();
        GoldPrice price = new GoldPrice(new Date(), "Gold 1", BigDecimal.valueOf(100), BigDecimal.valueOf(200));;
        when(goldPriceRepository.findByUpdateDate(date)).thenReturn(Optional.of(price));

        Optional<GoldPrice> result = goldPriceService.findByUpdateDate(date);
        assertTrue(result.isPresent());
        assertEquals(BigDecimal.valueOf(100), result.get().getBuyingPrice());
        verify(goldPriceRepository, times(1)).findByUpdateDate(date);
    }
}