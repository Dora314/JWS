package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.BuybackInvoiceDetail;
import com.vn.jewelry_management_system.domain.BuybackInvoiceDetailId;
import com.vn.jewelry_management_system.repository.BuybackInvoiceDetailRepository;
import com.vn.jewelry_management_system.service.BuybackInvoiceDetailService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class BuybackInvoiceDetailServiceTest {

    @Autowired
    private BuybackInvoiceDetailService buybackInvoiceDetailService;

    @MockBean
    private BuybackInvoiceDetailRepository buybackInvoiceDetailRepository;

    @Test
    public void testGetAllBuybackInvoiceDetails() {
        BuybackInvoiceDetail detail1 = new BuybackInvoiceDetail();
        BuybackInvoiceDetail detail2 = new BuybackInvoiceDetail();
        List<BuybackInvoiceDetail> details = Arrays.asList(detail1, detail2);

        when(buybackInvoiceDetailRepository.findAll()).thenReturn(details);

        List<BuybackInvoiceDetail> result = buybackInvoiceDetailService.getAllBuybackInvoiceDetails();
        assertEquals(2, result.size());
        verify(buybackInvoiceDetailRepository, times(1)).findAll();
    }

    @Test
    public void testGetBuybackInvoiceDetailById() {
        BuybackInvoiceDetailId id = new BuybackInvoiceDetailId(1, 1);
        BuybackInvoiceDetail detail = new BuybackInvoiceDetail();
        when(buybackInvoiceDetailRepository.findById(id)).thenReturn(Optional.of(detail));

        Optional<BuybackInvoiceDetail> result = buybackInvoiceDetailService.getBuybackInvoiceDetailById(id);
        assertTrue(result.isPresent());
        verify(buybackInvoiceDetailRepository, times(1)).findById(id);
    }

    @Test
    public void testSaveBuybackInvoiceDetail() {
        BuybackInvoiceDetail detail = new BuybackInvoiceDetail();
        when(buybackInvoiceDetailRepository.save(any(BuybackInvoiceDetail.class))).thenReturn(detail);

        BuybackInvoiceDetail result = buybackInvoiceDetailService.saveBuybackInvoiceDetail(detail);
        assertNotNull(result);
        verify(buybackInvoiceDetailRepository, times(1)).save(detail);
    }

    @Test
    public void testDeleteBuybackInvoiceDetail() {
        BuybackInvoiceDetailId id = new BuybackInvoiceDetailId(1, 1);
        doNothing().when(buybackInvoiceDetailRepository).deleteById(id);

        buybackInvoiceDetailService.deleteBuybackInvoiceDetail(id);
        verify(buybackInvoiceDetailRepository, times(1)).deleteById(id);
    }
}