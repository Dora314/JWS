package com.vn.jewelry_management_system;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.vn.jewelry_management_system.domain.ReturnPolicy;
import com.vn.jewelry_management_system.repository.ReturnPolicyRepository;
import com.vn.jewelry_management_system.service.ReturnPolicyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReturnPolicyServiceTest {

    @Mock
    private ReturnPolicyRepository returnPolicyRepository;

    @InjectMocks
    private ReturnPolicyService returnPolicyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllReturnPolicies() {
        ReturnPolicy policy1 = new ReturnPolicy();
        ReturnPolicy policy2 = new ReturnPolicy();
        List<ReturnPolicy> policies = Arrays.asList(policy1, policy2);

        when(returnPolicyRepository.findAll()).thenReturn(policies);

        List<ReturnPolicy> result = returnPolicyService.getAllReturnPolicies();
        assertEquals(2, result.size());
        verify(returnPolicyRepository, times(1)).findAll();
    }

    @Test
    public void testGetReturnPolicyById() {
        ReturnPolicy policy = new ReturnPolicy();
        when(returnPolicyRepository.findById(1)).thenReturn(Optional.of(policy));

        Optional<ReturnPolicy> result = returnPolicyService.getReturnPolicyById(1);
        assertTrue(result.isPresent());
        assertEquals(policy, result.get());
        verify(returnPolicyRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveReturnPolicy() {
        ReturnPolicy policy = new ReturnPolicy();
        when(returnPolicyRepository.save(policy)).thenReturn(policy);

        ReturnPolicy result = returnPolicyService.saveReturnPolicy(policy);
        assertEquals(policy, result);
        verify(returnPolicyRepository, times(1)).save(policy);
    }

    @Test
    public void testDeleteReturnPolicy() {
        doNothing().when(returnPolicyRepository).deleteById(1);

        returnPolicyService.deleteReturnPolicy(1);
        verify(returnPolicyRepository, times(1)).deleteById(1);
    }
}