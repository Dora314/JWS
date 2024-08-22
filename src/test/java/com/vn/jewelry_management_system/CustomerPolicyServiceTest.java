package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.CustomerPolicy;
import com.vn.jewelry_management_system.repository.CustomerPolicyRepository;
import com.vn.jewelry_management_system.service.CustomerPolicyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerPolicyServiceTest {

    @Mock
    private CustomerPolicyRepository customerPolicyRepository;

    @InjectMocks
    private CustomerPolicyService customerPolicyService;

    @Test
    public void testGetAllCustomerPolicies() {
        CustomerPolicy policy1 = new CustomerPolicy("Policy1", "Type1", BigDecimal.valueOf(10));
        CustomerPolicy policy2 = new CustomerPolicy("Policy2", "Type2", BigDecimal.valueOf(20));
        List<CustomerPolicy> policies = Arrays.asList(policy1, policy2);

        when(customerPolicyRepository.findAll()).thenReturn(policies);

        List<CustomerPolicy> result = customerPolicyService.getAllCustomerPolicies();
        assertEquals(2, result.size());
        verify(customerPolicyRepository, times(1)).findAll();
    }

    @Test
    public void testGetCustomerPolicyById() {
        CustomerPolicy policy = new CustomerPolicy("Policy1", "Type1", BigDecimal.valueOf(10));
        when(customerPolicyRepository.findById(1)).thenReturn(Optional.of(policy));

        Optional<CustomerPolicy> result = customerPolicyService.getCustomerPolicyById(1);
        assertTrue(result.isPresent());
        assertEquals("Policy1", result.get().getPolicyName());
        verify(customerPolicyRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveCustomerPolicy() {
        CustomerPolicy policy = new CustomerPolicy("Policy1", "Type1", BigDecimal.valueOf(10));
        when(customerPolicyRepository.save(policy)).thenReturn(policy);

        CustomerPolicy result = customerPolicyService.saveCustomerPolicy(policy);
        assertEquals("Policy1", result.getPolicyName());
        verify(customerPolicyRepository, times(1)).save(policy);
    }

    @Test
    public void testDeleteCustomerPolicy() {
        doNothing().when(customerPolicyRepository).deleteById(1);

        customerPolicyService.deleteCustomerPolicy(1);
        verify(customerPolicyRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFindByPolicyName() {
        CustomerPolicy policy = new CustomerPolicy("Policy1", "Type1", BigDecimal.valueOf(10));
        when(customerPolicyRepository.findByPolicyName("Policy1")).thenReturn(Optional.of(policy));

        Optional<CustomerPolicy> result = customerPolicyService.findByPolicyName("Policy1");
        assertTrue(result.isPresent());
        assertEquals("Policy1", result.get().getPolicyName());
        verify(customerPolicyRepository, times(1)).findByPolicyName("Policy1");
    }
}