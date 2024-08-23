package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Employee;
import com.vn.jewelry_management_system.repository.EmployeeRepository;
import com.vn.jewelry_management_system.service.EmployeeService;
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
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployees() {
        Employee employee1 = new Employee("John Doe", "123456789", "123 Street", "Manager", BigDecimal.valueOf(5000));
        Employee employee2 = new Employee("Jane Doe", "987654321", "456 Avenue", "Clerk", BigDecimal.valueOf(3000));
        List<Employee> employees = Arrays.asList(employee1, employee2);

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();
        assertEquals(2, result.size());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee("John Doe", "123456789", "123 Street", "Manager", BigDecimal.valueOf(5000));
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.getEmployeeById(1);
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getEmployeeName());
        verify(employeeRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee("John Doe", "123456789", "123 Street", "Manager", BigDecimal.valueOf(5000));
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee result = employeeService.saveEmployee(employee);
        assertEquals("John Doe", result.getEmployeeName());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void testDeleteEmployee() {
        doNothing().when(employeeRepository).deleteById(1);

        employeeService.deleteEmployee(1);
        verify(employeeRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFindByPhone() {
        Employee employee = new Employee("John Doe", "123456789", "123 Street", "Manager", BigDecimal.valueOf(5000));
        when(employeeRepository.findByPhone("123456789")).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.findByPhone("123456789");
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getEmployeeName());
        verify(employeeRepository, times(1)).findByPhone("123456789");
    }
}