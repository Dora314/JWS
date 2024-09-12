package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Customer;
import com.vn.jewelry_management_system.repository.CustomerRepository;
import com.vn.jewelry_management_system.service.CustomerService;
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

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCustomers() {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        List<Customer> customers = Arrays.asList(customer1, customer2);

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.getAllCustomers();
        assertEquals(2, result.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setCustomerId(1);

        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.getCustomerById(1);
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getCustomerId());
        verify(customerRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer();
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer result = customerService.saveCustomer(customer);
        assertNotNull(result);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testDeleteCustomer() {
        int customerId = 1;
        doNothing().when(customerRepository).deleteById(customerId);

        customerService.deleteCustomer(customerId);
        verify(customerRepository, times(1)).deleteById(customerId);
    }

    @Test
    public void testFindByPhone() {
        Customer customer = new Customer();
        customer.setPhone("123456789");

        when(customerRepository.findByPhone("123456789")).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.findByPhone("123456789");
        assertTrue(result.isPresent());
        assertEquals("123456789", result.get().getPhone());
        verify(customerRepository, times(1)).findByPhone("123456789");
    }
}