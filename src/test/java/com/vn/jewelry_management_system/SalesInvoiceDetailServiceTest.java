package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.SalesInvoiceDetail;
import com.vn.jewelry_management_system.domain.SalesInvoiceDetailId;
import com.vn.jewelry_management_system.repository.SalesInvoiceDetailRepository;
import com.vn.jewelry_management_system.service.SalesInvoiceDetailService;
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

public class SalesInvoiceDetailServiceTest {

    @Mock
    private SalesInvoiceDetailRepository salesInvoiceDetailRepository;

    @InjectMocks
    private SalesInvoiceDetailService salesInvoiceDetailService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllSalesInvoiceDetails() {
        SalesInvoiceDetail detail1 = new SalesInvoiceDetail();
        SalesInvoiceDetail detail2 = new SalesInvoiceDetail();
        List<SalesInvoiceDetail> details = Arrays.asList(detail1, detail2);

        when(salesInvoiceDetailRepository.findAll()).thenReturn(details);

        List<SalesInvoiceDetail> result = salesInvoiceDetailService.getAllSalesInvoiceDetails();

        assertEquals(2, result.size());
        verify(salesInvoiceDetailRepository, times(1)).findAll();
    }

    @Test
    public void testGetSalesInvoiceDetailById() {
        SalesInvoiceDetailId id = new SalesInvoiceDetailId(1, 1);
        SalesInvoiceDetail detail = new SalesInvoiceDetail();
        when(salesInvoiceDetailRepository.findById(id)).thenReturn(Optional.of(detail));

        Optional<SalesInvoiceDetail> result = salesInvoiceDetailService.getSalesInvoiceDetailById(id);

        assertTrue(result.isPresent());
        assertEquals(detail, result.get());
        verify(salesInvoiceDetailRepository, times(1)).findById(id);
    }

    @Test
    public void testSaveSalesInvoiceDetail() {
        SalesInvoiceDetail detail = new SalesInvoiceDetail();
        when(salesInvoiceDetailRepository.save(detail)).thenReturn(detail);

        SalesInvoiceDetail result = salesInvoiceDetailService.saveSalesInvoiceDetail(detail);

        assertEquals(detail, result);
        verify(salesInvoiceDetailRepository, times(1)).save(detail);
    }

    @Test
    public void testDeleteSalesInvoiceDetail() {
        SalesInvoiceDetailId id = new SalesInvoiceDetailId(1, 1);
        doNothing().when(salesInvoiceDetailRepository).deleteById(id);

        salesInvoiceDetailService.deleteSalesInvoiceDetail(id);

        verify(salesInvoiceDetailRepository, times(1)).deleteById(id);
    }
}