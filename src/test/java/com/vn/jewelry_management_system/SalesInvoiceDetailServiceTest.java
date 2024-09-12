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

import java.math.BigDecimal;
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
        when(salesInvoiceDetailRepository.findAll()).thenReturn(Arrays.asList(detail1, detail2));

        List<SalesInvoiceDetail> result = salesInvoiceDetailService.getAllSalesInvoiceDetails();

        assertEquals(2, result.size());
        verify(salesInvoiceDetailRepository, times(1)).findAll();
    }

    @Test
    public void testGetSalesInvoiceDetailById() {
        SalesInvoiceDetailId id = new SalesInvoiceDetailId();
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
        SalesInvoiceDetailId id = new SalesInvoiceDetailId();

        salesInvoiceDetailService.deleteSalesInvoiceDetail(id);

        verify(salesInvoiceDetailRepository, times(1)).deleteById(id);
    }

    @Test
    public void testGetDetailsBySalesInvoiceId() {
        int salesInvoiceId = 1;
        SalesInvoiceDetail detail1 = new SalesInvoiceDetail();
        SalesInvoiceDetail detail2 = new SalesInvoiceDetail();
        when(salesInvoiceDetailRepository.findAllById_SalesInvoiceId(salesInvoiceId)).thenReturn(Arrays.asList(detail1, detail2));

        List<SalesInvoiceDetail> result = salesInvoiceDetailService.getDetailsBySalesInvoiceId(salesInvoiceId);

        assertEquals(2, result.size());
        verify(salesInvoiceDetailRepository, times(1)).findAllById_SalesInvoiceId(salesInvoiceId);
    }

    @Test
    public void testGetTotalAmountByInvoiceId() {
        int salesInvoiceId = 1;
        SalesInvoiceDetail detail1 = new SalesInvoiceDetail();
        detail1.setUnitPrice(BigDecimal.valueOf(100));
        detail1.setQuantity(2);
        SalesInvoiceDetail detail2 = new SalesInvoiceDetail();
        detail2.setUnitPrice(BigDecimal.valueOf(200));
        detail2.setQuantity(1);
        when(salesInvoiceDetailRepository.findAllById_SalesInvoiceId(salesInvoiceId)).thenReturn(Arrays.asList(detail1, detail2));

        BigDecimal result = salesInvoiceDetailService.getTotalAmountByInvoiceId(salesInvoiceId);

        assertEquals(BigDecimal.valueOf(400), result);
        verify(salesInvoiceDetailRepository, times(1)).findAllById_SalesInvoiceId(salesInvoiceId);
    }
}