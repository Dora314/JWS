package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.BuybackInvoiceController;
import com.vn.jewelry_management_system.domain.BuybackInvoice;
import com.vn.jewelry_management_system.service.BuybackInvoiceService;
import com.vn.jewelry_management_system.service.CustomerService;
import com.vn.jewelry_management_system.service.EmployeeService;
import com.vn.jewelry_management_system.service.StallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BuybackInvoiceControllerTest {

    @Mock
    private BuybackInvoiceService buybackInvoiceService;

    @Mock
    private CustomerService customerService;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private StallService stallService;

    @Mock
    private Model model;

    @InjectMocks
    private BuybackInvoiceController buybackInvoiceController;

    private BuybackInvoice buybackInvoice;

    @BeforeEach
    public void setUp() {
        buybackInvoice = new BuybackInvoice();
        buybackInvoice.setBuybackInvoiceId(1);
        buybackInvoice.setTotalAmount(BigDecimal.valueOf(100));
    }

    @Test
    public void testShowEditForm() {
        when(buybackInvoiceService.getBuybackInvoiceById(1)).thenReturn(Optional.of(buybackInvoice));

        String viewName = buybackInvoiceController.showEditForm(1, model);

        assertEquals("admin/buyback-invoice/edit", viewName);
        verify(model, times(1)).addAttribute("buybackInvoice", buybackInvoice);
        verify(model, times(1)).addAttribute("customers", customerService.getAllCustomers());
        verify(model, times(1)).addAttribute("employees", employeeService.getAllEmployees());
        verify(model, times(1)).addAttribute("stalls", stallService.getAllStalls());
    }

    @Test
    public void testUpdateBuybackInvoice() {
        when(buybackInvoiceService.saveBuybackInvoice(any(BuybackInvoice.class))).thenReturn(buybackInvoice);

        String viewName = buybackInvoiceController.updateBuybackInvoice(1, buybackInvoice);

        assertEquals("redirect:/admin/buyback-invoices", viewName);
        verify(buybackInvoiceService, times(1)).saveBuybackInvoice(buybackInvoice);
        assertEquals(1, buybackInvoice.getBuybackInvoiceId());
    }
}