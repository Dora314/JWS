package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.CustomerPolicyController;
import com.vn.jewelry_management_system.domain.CustomerPolicy;
import com.vn.jewelry_management_system.service.CustomerPolicyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerPolicyControllerTest {

    @Mock
    private CustomerPolicyService customerPolicyService;

    @Mock
    private Model model;

    @InjectMocks
    private CustomerPolicyController customerPolicyController;

    private List<CustomerPolicy> customerPolicies;

    @BeforeEach
    public void setUp() {
        customerPolicies = Collections.singletonList(new CustomerPolicy());
    }

    @Test
    public void testShowAllCustomerPolicies() {
        when(customerPolicyService.getAllCustomerPolicies()).thenReturn(customerPolicies);

        String viewName = customerPolicyController.showAllCustomerPolicies(model);

        assertEquals("admin/customer-policy/table-customer-policy", viewName);
        verify(model, times(1)).addAttribute("customerPolicies", customerPolicies);
        verify(customerPolicyService, times(1)).getAllCustomerPolicies();
    }
}