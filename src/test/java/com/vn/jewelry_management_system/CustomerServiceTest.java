package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Customer;
import com.vn.jewelry_management_system.repository.CustomerRepository;
import com.vn.jewelry_management_system.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testGetAllCustomers() {
        Customer customer1 = new Customer("John Doe", "1234567890", "123 Street", "john@example.com", 10);
        Customer customer2 = new Customer("Jane Doe", "0987654321", "456 Avenue", "jane@example.com", 20);
        List<Customer> customers = Arrays.asList(customer1, customer2);

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.getAllCustomers();
        assertEquals(2, result.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer("John Doe", "1234567890", "123 Street", "john@example.com", 10);
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.getCustomerById(1);
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getCustomerName());
        verify(customerRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer("John Doe", "1234567890", "123 Street", "john@example.com", 10);
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer result = customerService.saveCustomer(customer);
        assertEquals("John Doe", result.getCustomerName());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testDeleteCustomer() {
        doNothing().when(customerRepository).deleteById(1);

        customerService.deleteCustomer(1);
        verify(customerRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFindByPhone() {
        Customer customer = new Customer("John Doe", "1234567890", "123 Street", "john@example.com", 10);
        when(customerRepository.findByPhone("1234567890")).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.findByPhone("1234567890");
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getCustomerName());
        verify(customerRepository, times(1)).findByPhone("1234567890");
    }
}