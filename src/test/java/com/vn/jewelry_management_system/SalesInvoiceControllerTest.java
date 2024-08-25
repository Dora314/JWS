package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.SalesInvoiceController;
import com.vn.jewelry_management_system.domain.*;
import com.vn.jewelry_management_system.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@WebMvcTest(SalesInvoiceController.class)
public class SalesInvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalesInvoiceService salesInvoiceService;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private StallService stallService;

    @MockBean
    private ProductService productService;

    @MockBean
    private SalesInvoiceDetailService salesInvoiceDetailService;

    @MockBean
    private InvoicePdfService invoicePdfService;

    @Test
    public void testShowAllSalesInvoices() throws Exception {
        when(salesInvoiceService.getAllSalesInvoices()).thenReturn(List.of(new SalesInvoice()));

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/sales-invoices"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin/sales-invoice/table-sales-invoice"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("salesInvoices"));
    }

    @Test
    public void testShowCreateForm() throws Exception {
        when(customerService.getAllCustomers()).thenReturn(List.of(new Customer()));
        when(employeeService.getAllEmployees()).thenReturn(List.of(new Employee()));
        when(stallService.getAllStalls()).thenReturn(List.of(new Stall()));
        when(productService.getAllProducts()).thenReturn(List.of(new Product()));

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/sales-invoices/create"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin/sales-invoice/create"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("salesInvoice"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customers"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("employees"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("stalls"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("products"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("salesInvoiceDetails"));
    }

    @Test
    public void testCreateSalesInvoice() throws Exception {
        Product product = new Product();
        product.setProductId(1);
        when(productService.getProductById(anyInt())).thenReturn(Optional.of(product));
        when(productService.calculateSellingPrice(any(Product.class))).thenReturn(BigDecimal.TEN);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/sales-invoices/create")
                        .param("productIds", "1")
                        .param("quantities", "2"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/admin/sales-invoices"));
    }

    @Test
    public void testShowEditForm() throws Exception {
        SalesInvoice salesInvoice = new SalesInvoice();
        when(salesInvoiceService.getSalesInvoiceById(anyInt())).thenReturn(Optional.of(salesInvoice));
        when(customerService.getAllCustomers()).thenReturn(List.of(new Customer()));
        when(employeeService.getAllEmployees()).thenReturn(List.of(new Employee()));
        when(stallService.getAllStalls()).thenReturn(List.of(new Stall()));
        when(productService.getAllProducts()).thenReturn(List.of(new Product()));

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/sales-invoices/edit/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin/sales-invoice/edit"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("salesInvoice"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customers"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("employees"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("stalls"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("products"));
    }

    @Test
    public void testDownloadInvoicePdf() throws Exception {
        SalesInvoice salesInvoice = new SalesInvoice();
        salesInvoice.setSalesInvoiceId(1);
        when(salesInvoiceService.getSalesInvoiceById(anyInt())).thenReturn(Optional.of(salesInvoice));
        when(invoicePdfService.generateInvoicePdf(any(SalesInvoice.class))).thenReturn(new byte[0]);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/sales-invoices/download/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/pdf"))
                .andExpect(MockMvcResultMatchers.header().string("Content-Disposition", "attachment; filename=invoice_1.pdf"));
    }
}