package com.vn.jewelry_management_system;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        // Arrange
        ReturnPolicy policy1 = new ReturnPolicy(
            "CDT123",  // cdt
            30         // duration
        );
        policy1.setReturnPolicyId(1);
        ReturnPolicy policy2 = new ReturnPolicy(
            "CDT123",  // cdt
            30         // duration
        );
        policy2.setReturnPolicyId(2);
        List<ReturnPolicy> policyList = Arrays.asList(policy1, policy2);
        when(returnPolicyRepository.findAll()).thenReturn(policyList);

        // Act
        List<ReturnPolicy> result = returnPolicyService.getAllReturnPolicies();

        // Assert
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getReturnPolicyId());
        assertEquals(2, result.get(1).getReturnPolicyId());
    }

    @Test
    public void testGetReturnPolicyById() {
        // Arrange
        ReturnPolicy policy = new ReturnPolicy(
            "CDT123",  // cdt
            30         // duration
        );
        policy.setReturnPolicyId(1);
        when(returnPolicyRepository.findById(1)).thenReturn(Optional.of(policy));

        // Act
        Optional<ReturnPolicy> result = returnPolicyService.getReturnPolicyById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getReturnPolicyId());
    }

    @Test
    public void testSaveReturnPolicy() {
        // Arrange
        ReturnPolicy policy = new ReturnPolicy(
            "CDT123",  // cdt
            30         // duration
        );
        policy.setReturnPolicyId(1);

        when(returnPolicyRepository.save(policy)).thenReturn(policy);

        // Act
        ReturnPolicy result = returnPolicyService.saveReturnPolicy(policy);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getReturnPolicyId());
    }

    @Test
    public void testDeleteReturnPolicy() {
        // Act
        returnPolicyService.deleteReturnPolicy(1);

        // Assert
        verify(returnPolicyRepository, times(1)).deleteById(1);
    }
}