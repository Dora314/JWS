package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.BuybackInvoice;
import com.vn.jewelry_management_system.repository.BuybackInvoiceRepository;
import com.vn.jewelry_management_system.service.BuybackInvoiceService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BuybackInvoiceServiceTest {

    @Mock
    private BuybackInvoiceRepository buybackInvoiceRepository;

    @InjectMocks
    private BuybackInvoiceService buybackInvoiceService;

    @Test
    public void testGetAllBuybackInvoices() {
        BuybackInvoice invoice1 = new BuybackInvoice(null, null, null, BigDecimal.valueOf(100));
        BuybackInvoice invoice2 = new BuybackInvoice(null, null, null, BigDecimal.valueOf(200));
        List<BuybackInvoice> invoices = Arrays.asList(invoice1, invoice2);

        when(buybackInvoiceRepository.findAll()).thenReturn(invoices);

        List<BuybackInvoice> result = buybackInvoiceService.getAllBuybackInvoices();
        assertEquals(2, result.size());
        verify(buybackInvoiceRepository, times(1)).findAll();
    }

    @Test
    public void testGetBuybackInvoiceById() {
        BuybackInvoice invoice = new BuybackInvoice(null, null, null, BigDecimal.valueOf(100));
        when(buybackInvoiceRepository.findById(1)).thenReturn(Optional.of(invoice));

        Optional<BuybackInvoice> result = buybackInvoiceService.getBuybackInvoiceById(1);
        assertTrue(result.isPresent());
        assertEquals(BigDecimal.valueOf(100), result.get().getTotalAmount());
        verify(buybackInvoiceRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveBuybackInvoice() {
        BuybackInvoice invoice = new BuybackInvoice(null, null, null, BigDecimal.valueOf(100));
        when(buybackInvoiceRepository.save(invoice)).thenReturn(invoice);

        BuybackInvoice result = buybackInvoiceService.saveBuybackInvoice(invoice);
        assertEquals(BigDecimal.valueOf(100), result.getTotalAmount());
        verify(buybackInvoiceRepository, times(1)).save(invoice);
    }

    @Test
    public void testDeleteBuybackInvoice() {
        doNothing().when(buybackInvoiceRepository).deleteById(1);

        buybackInvoiceService.deleteBuybackInvoice(1);
        verify(buybackInvoiceRepository, times(1)).deleteById(1);
    }
}