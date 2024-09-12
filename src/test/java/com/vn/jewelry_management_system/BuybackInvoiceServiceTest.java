package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.BuybackInvoice;
import com.vn.jewelry_management_system.repository.BuybackInvoiceRepository;
import com.vn.jewelry_management_system.service.BuybackInvoiceService;
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

public class BuybackInvoiceServiceTest {

    @Mock
    private BuybackInvoiceRepository buybackInvoiceRepository;

    @InjectMocks
    private BuybackInvoiceService buybackInvoiceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBuybackInvoices() {
        BuybackInvoice invoice1 = new BuybackInvoice();
        BuybackInvoice invoice2 = new BuybackInvoice();
        List<BuybackInvoice> invoices = Arrays.asList(invoice1, invoice2);

        when(buybackInvoiceRepository.findAll()).thenReturn(invoices);

        List<BuybackInvoice> result = buybackInvoiceService.getAllBuybackInvoices();
        assertEquals(2, result.size());
        verify(buybackInvoiceRepository, times(1)).findAll();
    }

    @Test
    public void testGetBuybackInvoiceById() {
        BuybackInvoice invoice = new BuybackInvoice();
        when(buybackInvoiceRepository.findById(1)).thenReturn(Optional.of(invoice));

        Optional<BuybackInvoice> result = buybackInvoiceService.getBuybackInvoiceById(1);
        assertTrue(result.isPresent());
        assertEquals(invoice, result.get());
        verify(buybackInvoiceRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveBuybackInvoice() {
        BuybackInvoice invoice = new BuybackInvoice();
        when(buybackInvoiceRepository.save(invoice)).thenReturn(invoice);

        BuybackInvoice result = buybackInvoiceService.saveBuybackInvoice(invoice);
        assertEquals(invoice, result);
        verify(buybackInvoiceRepository, times(1)).save(invoice);
    }

    @Test
    public void testDeleteBuybackInvoice() {
        doNothing().when(buybackInvoiceRepository).deleteById(1);

        buybackInvoiceService.deleteBuybackInvoice(1);
        verify(buybackInvoiceRepository, times(1)).deleteById(1);
    }

    @Test
    public void testCountBuybackInvoices() {
        when(buybackInvoiceRepository.count()).thenReturn(5L);

        long result = buybackInvoiceService.countBuybackInvoices();
        assertEquals(5L, result);
        verify(buybackInvoiceRepository, times(1)).count();
    }
}