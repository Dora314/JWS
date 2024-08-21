package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerConstructorAndGettersAndSetters() {
        // Create a Customer object
        Customer customer = new Customer("John Doe", "123-456-7890", "123 Main St", "john.doe@example.com", 100);

        // Assert that the constructor and getters work correctly
        assertEquals("John Doe", customer.getCustomerName());
        assertEquals("123-456-7890", customer.getPhone());
        assertEquals("123 Main St", customer.getAddress());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals(100, customer.getLoyaltyPoint());

        // Update the customer's information using setters
        customer.setCustomerName("Jane Doe");
        customer.setPhone("987-654-3210");
        customer.setAddress("456 Oak Ave");
        customer.setEmail("jane.doe@example.com");
        customer.setLoyaltyPoint(150);

        // Assert that the setters work correctly
        assertEquals("Jane Doe", customer.getCustomerName());
        assertEquals("987-654-3210", customer.getPhone());
        assertEquals("456 Oak Ave", customer.getAddress());
        assertEquals("jane.doe@example.com", customer.getEmail());
        assertEquals(150, customer.getLoyaltyPoint());
    }

    @Test
    public void testCustomerToString() {
        // Create a Customer object
        Customer customer = new Customer("John Doe", "123-456-7890", "123 Main St", "john.doe@example.com", 100);

        // Set the customer ID (normally done by the database)
        customer.setCustomerId(1);

        // Assert that the toString method produces the expected output
        String expectedToString = "Customer [customerId=1, customerName=John Doe, phone=123-456-7890, address=123 Main St, email=john.doe@example.com, loyaltyPoint=100]";
        assertEquals(expectedToString, customer.toString());
    }
}