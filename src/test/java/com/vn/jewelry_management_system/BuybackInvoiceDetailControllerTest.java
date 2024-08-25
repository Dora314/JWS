package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.BuybackInvoiceDetailController;
import com.vn.jewelry_management_system.domain.BuybackInvoiceDetail;
import com.vn.jewelry_management_system.domain.BuybackInvoiceDetailId;
import com.vn.jewelry_management_system.service.BuybackInvoiceDetailService;
import com.vn.jewelry_management_system.service.BuybackInvoiceService;
import com.vn.jewelry_management_system.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BuybackInvoiceDetailControllerTest {

    @Mock
    private BuybackInvoiceDetailService buybackInvoiceDetailService;

    @Mock
    private BuybackInvoiceService buybackInvoiceService;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private BuybackInvoiceDetailController buybackInvoiceDetailController;

    private BuybackInvoiceDetail buybackInvoiceDetail;

    @BeforeEach
    public void setUp() {
        buybackInvoiceDetail = new BuybackInvoiceDetail();
        BuybackInvoiceDetailId id = new BuybackInvoiceDetailId(1, 1);
        buybackInvoiceDetail.setId(id);
    }

    @Test
    public void testShowEditForm_BuybackInvoiceDetailFound() {
        when(buybackInvoiceDetailService.getBuybackInvoiceDetailById(any(BuybackInvoiceDetailId.class)))
                .thenReturn(Optional.of(buybackInvoiceDetail));
        when(buybackInvoiceService.getAllBuybackInvoices()).thenReturn(Collections.emptyList());
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());
    
        String viewName = buybackInvoiceDetailController.showEditForm(1, 1, model);
    
        assertEquals("admin/buyback-invoice-detail/edit", viewName);
        verify(model, times(1)).addAttribute("buybackInvoiceDetail", buybackInvoiceDetail);
        verify(model, times(1)).addAttribute("buybackInvoices", Collections.emptyList());
        verify(model, times(1)).addAttribute("products", Collections.emptyList());
    }

    @Test
    public void testShowEditForm_BuybackInvoiceDetailNotFound() {
        when(buybackInvoiceDetailService.getBuybackInvoiceDetailById(any(BuybackInvoiceDetailId.class)))
                .thenReturn(Optional.empty());
        when(buybackInvoiceService.getAllBuybackInvoices()).thenReturn(Collections.emptyList());
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());

        String viewName = buybackInvoiceDetailController.showEditForm(1, 1, model);

        assertEquals("admin/buyback-invoice-detail/edit", viewName);
        verify(model, times(1)).addAttribute("buybackInvoiceDetail", null);
        verify(model, times(1)).addAttribute("buybackInvoices", buybackInvoiceService.getAllBuybackInvoices());
        verify(model, times(1)).addAttribute("products", productService.getAllProducts());
    }
}