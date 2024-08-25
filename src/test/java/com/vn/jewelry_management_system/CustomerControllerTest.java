package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.CustomerController;
import com.vn.jewelry_management_system.domain.Customer;
import com.vn.jewelry_management_system.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private Model model;

    @InjectMocks
    private CustomerController customerController;

    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerName("John Doe");
    }

    @Test
    public void testUpdateCustomer_CustomerExists() {
        String viewName = customerController.updateCustomer(1, customer);

        verify(customerService, times(1)).saveCustomer(customer);
        assertEquals("redirect:/admin/customers", viewName);
    }

    @Test
    public void testUpdateCustomer_CustomerDoesNotExist() {
        // No need to stub getCustomerById here as it is not used in the method
        String viewName = customerController.updateCustomer(1, customer);

        verify(customerService, times(1)).saveCustomer(customer);
        assertEquals("redirect:/admin/customers", viewName);
    }

    @Test
    public void testShowAllCustomers() {
        String viewName = customerController.showAllCustomers(model);

        verify(customerService, times(1)).getAllCustomers();
        assertEquals("admin/customer/table-customer", viewName);
    }

    @Test
    public void testShowCreateForm() {
        String viewName = customerController.showCreateForm(model);

        assertEquals("admin/customer/create", viewName);
    }

    @Test
    public void testCreateCustomer() {
        String viewName = customerController.createCustomer(customer);

        verify(customerService, times(1)).saveCustomer(customer);
        assertEquals("redirect:/admin/customers", viewName);
    }

    @Test
    public void testShowEditForm_CustomerExists() {
        when(customerService.getCustomerById(anyInt())).thenReturn(Optional.of(customer));

        String viewName = customerController.showEditForm(1, model);

        verify(model, times(1)).addAttribute("customer", customer);
        assertEquals("admin/customer/edit", viewName);
    }

    @Test
    public void testShowEditForm_CustomerDoesNotExist() {
        when(customerService.getCustomerById(anyInt())).thenReturn(Optional.empty());

        String viewName = customerController.showEditForm(1, model);

        assertEquals("redirect:/admin/customers", viewName);
    }

    @Test
    public void testDeleteCustomer() {
        String viewName = customerController.deleteCustomer(1);

        verify(customerService, times(1)).deleteCustomer(1);
        assertEquals("redirect:/admin/customers", viewName);
    }
}