package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.EmployeeController;
import com.vn.jewelry_management_system.domain.Employee;
import com.vn.jewelry_management_system.domain.Stall;
import com.vn.jewelry_management_system.service.EmployeeService;
import com.vn.jewelry_management_system.service.StallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @Mock
    private StallService stallService;

    @InjectMocks
    private EmployeeController employeeController;

    private Employee employee;
    private Stall stall;

    @BeforeEach
    public void setUp() {
        employee = new Employee();
        employee.setEmployeeId(1);
        stall = new Stall();
        stall.setStallId(1);
        employee.setStall(stall);
    }

    @Test
    public void testUpdateEmployee_StallFound() {
        when(stallService.getStallById(1)).thenReturn(Optional.of(stall));

        String viewName = employeeController.updateEmployee(1, employee);

        verify(employeeService, times(1)).saveEmployee(employee);
        assertEquals("redirect:/admin/employees", viewName);
    }

    @Test
    public void testUpdateEmployee_StallNotFound() {
        when(stallService.getStallById(1)).thenReturn(Optional.empty());

        String viewName = employeeController.updateEmployee(1, employee);

        verify(employeeService, times(1)).saveEmployee(employee);
        assertEquals("redirect:/admin/employees", viewName);
    }
}