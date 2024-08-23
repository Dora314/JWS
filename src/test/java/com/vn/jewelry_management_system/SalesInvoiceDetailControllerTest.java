package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.SalesInvoiceDetailController;
import com.vn.jewelry_management_system.domain.Product;
import com.vn.jewelry_management_system.domain.SalesInvoice;
import com.vn.jewelry_management_system.domain.SalesInvoiceDetail;
import com.vn.jewelry_management_system.service.ProductService;
import com.vn.jewelry_management_system.service.SalesInvoiceDetailService;
import com.vn.jewelry_management_system.service.SalesInvoiceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(SalesInvoiceDetailController.class)
public class SalesInvoiceDetailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalesInvoiceDetailService salesInvoiceDetailService;

    @MockBean
    private SalesInvoiceService salesInvoiceService;

    @MockBean
    private ProductService productService;

    @Test
    public void testShowAllSalesInvoiceDetails() throws Exception {
        // Mock the responses from the services
        when(salesInvoiceDetailService.getAllSalesInvoiceDetails()).thenReturn(List.of(new SalesInvoiceDetail()));
        when(salesInvoiceService.getAllSalesInvoices()).thenReturn(List.of(new SalesInvoice()));
        when(productService.getAllProducts()).thenReturn(List.of(new Product()));

        // Perform the GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/sales-invoice-details"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin/sales-invoice-detail/table-sales-invoice-detail"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("salesInvoiceDetails"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("salesInvoices"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("products"));
    }
}