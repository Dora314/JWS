package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.SalesInvoice;
import com.vn.jewelry_management_system.repository.SalesInvoiceRepository;
import com.vn.jewelry_management_system.service.SalesInvoiceService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SalesInvoiceServiceTest {

    @Mock
    private SalesInvoiceRepository salesInvoiceRepository;

    @InjectMocks
    private SalesInvoiceService salesInvoiceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllSalesInvoices() {
        // Arrange
        SalesInvoice invoice1 = new SalesInvoice(null, null, null, new BigDecimal("100.0"), new BigDecimal("10.0"), "Cash");
        SalesInvoice invoice2 = new SalesInvoice(null, null, null, new BigDecimal("200.0"), new BigDecimal("20.0"), "Credit");
        List<SalesInvoice> invoiceList = Arrays.asList(invoice1, invoice2);
        when(salesInvoiceRepository.findAll()).thenReturn(invoiceList);

        // Act
        List<SalesInvoice> result = salesInvoiceService.getAllSalesInvoices();

        // Assert
        assertEquals(2, result.size());
        assertEquals(new BigDecimal("100.0"), result.get(0).getTotalAmount());
        assertEquals(new BigDecimal("200.0"), result.get(1).getTotalAmount());
    }

    @Test
    public void testGetSalesInvoiceById() {
        // Arrange
        SalesInvoice invoice = new SalesInvoice(null, null, null, new BigDecimal("100.0"), new BigDecimal("10.0"), "Cash");
        when(salesInvoiceRepository.findById(1)).thenReturn(Optional.of(invoice));

        // Act
        Optional<SalesInvoice> result = salesInvoiceService.getSalesInvoiceById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(new BigDecimal("100.0"), result.get().getTotalAmount());
    }

    @Test
    public void testSaveSalesInvoice() {
        // Arrange
        SalesInvoice invoice = new SalesInvoice(null, null, null, new BigDecimal("100.0"), new BigDecimal("10.0"), "Cash");
        when(salesInvoiceRepository.save(invoice)).thenReturn(invoice);

        // Act
        SalesInvoice result = salesInvoiceService.saveSalesInvoice(invoice);

        // Assert
        assertNotNull(result);
        assertEquals(new BigDecimal("100.0"), result.getTotalAmount());
    }

    @Test
    public void testDeleteSalesInvoice() {
        // Act
        salesInvoiceService.deleteSalesInvoice(1);

        // Assert
        verify(salesInvoiceRepository, times(1)).deleteById(1);
    }
}