package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.CustomerPolicy;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerPolicyTest {

    @Test
    public void testCustomerPolicyConstructorAndGettersAndSetters() {
        // Create a CustomerPolicy object
        CustomerPolicy policy = new CustomerPolicy("Gold Member Discount", "Gold", new BigDecimal("0.10"));

        // Assert that the constructor and getters work correctly
        assertEquals("Gold Member Discount", policy.getPolicyName());
        assertEquals("Gold", policy.getCustomerType());
        assertEquals(new BigDecimal("0.10"), policy.getDiscountRate());

        // Update the policy's information using setters
        policy.setPolicyName("Platinum Member Discount");
        policy.setCustomerType("Platinum");
        policy.setDiscountRate(new BigDecimal("0.15"));

        // Assert that the setters work correctly
        assertEquals("Platinum Member Discount", policy.getPolicyName());
        assertEquals("Platinum", policy.getCustomerType());
        assertEquals(new BigDecimal("0.15"), policy.getDiscountRate());
    }

    @Test
    public void testCustomerPolicyToString() {
        // Create a CustomerPolicy object
        CustomerPolicy policy = new CustomerPolicy("Gold Member Discount", "Gold", new BigDecimal("0.10"));

        // Set the policy ID (normally done by the database)
        policy.setPolicyId(1);

        // Assert that the toString method produces the expected output
        String expectedToString = "CustomerPolicy [policyId=1, policyName=Gold Member Discount, customerType=Gold, discountRate=0.10]";
        assertEquals(expectedToString, policy.toString());
    }
}