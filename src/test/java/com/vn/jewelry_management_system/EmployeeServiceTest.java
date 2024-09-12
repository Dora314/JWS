package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Employee;
import com.vn.jewelry_management_system.repository.EmployeeRepository;
import com.vn.jewelry_management_system.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEmployees() {
        Employee employee1 = new Employee(1, "John Doe", "123456789", "123 Main St", "Manager", new BigDecimal("50000"));
        Employee employee2 = new Employee(2, "Mark Zurk", "123456789", "123 Main St", "Manager", new BigDecimal("50000"));
        List<Employee> employees = Arrays.asList(employee1, employee2);

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getEmployeeName());
        assertEquals("Mark Zurk", result.get(1).getEmployeeName());
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee(1, "John Doe", "123456789", "123 Main St", "Manager", new BigDecimal("50000"));
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.getEmployeeById(1);
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getEmployeeName());
    }

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee(1, "John Doe", "123456789", "123 Main St", "Manager", new BigDecimal("50000"));
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee result = employeeService.saveEmployee(employee);
        assertEquals("John Doe", result.getEmployeeName());
    }

    @Test
    public void testDeleteEmployee() {
        doNothing().when(employeeRepository).deleteById(1);

        employeeService.deleteEmployee(1);
        verify(employeeRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFindByPhone() {
        Employee employee = new Employee(1, "John Doe", "123456789", "123 Main St", "Manager", new BigDecimal("50000"));
        when(employeeRepository.findByPhone("123456789")).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.findByPhone("123456789");
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getEmployeeName());
    }
}