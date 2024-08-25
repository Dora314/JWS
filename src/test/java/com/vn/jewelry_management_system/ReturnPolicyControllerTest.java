package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.ReturnPolicyController;
import com.vn.jewelry_management_system.domain.ReturnPolicy;
import com.vn.jewelry_management_system.service.ReturnPolicyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReturnPolicyControllerTest {

    @Mock
    private ReturnPolicyService returnPolicyService;

    @Mock
    private Model model;

    @InjectMocks
    private ReturnPolicyController returnPolicyController;

    private ReturnPolicy returnPolicy;

    @BeforeEach
    public void setUp() {
        returnPolicy = new ReturnPolicy();
        returnPolicy.setReturnPolicyId(1);
    }

    @Test
    public void testShowAllReturnPolicies() {
        when(returnPolicyService.getAllReturnPolicies()).thenReturn(Collections.emptyList());

        String viewName = returnPolicyController.showAllReturnPolicies(model);

        assertEquals("admin/return-policy/table-return-policy", viewName);
        verify(model, times(1)).addAttribute("returnPolicies", Collections.emptyList());
    }

    @Test
    public void testShowCreateForm() {
        String viewName = returnPolicyController.showCreateForm(model);

        assertEquals("admin/return-policy/create", viewName);

        ArgumentCaptor<ReturnPolicy> captor = ArgumentCaptor.forClass(ReturnPolicy.class);
        verify(model, times(1)).addAttribute(eq("returnPolicy"), captor.capture());

        ReturnPolicy capturedReturnPolicy = captor.getValue();
        assertEquals(0, capturedReturnPolicy.getReturnPolicyId());
        assertNull(capturedReturnPolicy.getCdt());
        assertEquals(0, capturedReturnPolicy.getDuration());
    }

    @Test
    public void testCreateReturnPolicy() {
        String viewName = returnPolicyController.createReturnPolicy(returnPolicy);

        assertEquals("redirect:/admin/return-policies", viewName);
        verify(returnPolicyService, times(1)).saveReturnPolicy(returnPolicy);
    }

    @Test
    public void testShowEditForm_ReturnPolicyFound() {
        when(returnPolicyService.getReturnPolicyById(1)).thenReturn(Optional.of(returnPolicy));

        String viewName = returnPolicyController.showEditForm(1, model);

        assertEquals("admin/return-policy/edit", viewName);
        verify(model, times(1)).addAttribute("returnPolicy", returnPolicy);
    }

    @Test
    public void testShowEditForm_ReturnPolicyNotFound() {
        when(returnPolicyService.getReturnPolicyById(1)).thenReturn(Optional.empty());

        String viewName = returnPolicyController.showEditForm(1, model);

        assertEquals("admin/return-policy/edit", viewName);
        verify(model, times(1)).addAttribute("returnPolicy", null);
    }

    @Test
    public void testUpdateReturnPolicy() {
        String viewName = returnPolicyController.updateReturnPolicy(1, returnPolicy);

        assertEquals("redirect:/admin/return-policies", viewName);
        verify(returnPolicyService, times(1)).saveReturnPolicy(returnPolicy);
    }

    @Test
    public void testDeleteReturnPolicy() {
        String viewName = returnPolicyController.deleteReturnPolicy(1);

        assertEquals("redirect:/admin/return-policies", viewName);
        verify(returnPolicyService, times(1)).deleteReturnPolicy(1);
    }
}