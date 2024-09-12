package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Employee;
import com.vn.jewelry_management_system.domain.SalesInvoice;
import com.vn.jewelry_management_system.domain.Stall;
import com.vn.jewelry_management_system.repository.SalesInvoiceRepository;
import com.vn.jewelry_management_system.service.EmployeeService;
import com.vn.jewelry_management_system.service.SalesInvoiceService;
import com.vn.jewelry_management_system.service.StallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SalesInvoiceServiceTest {

    @Mock
    private SalesInvoiceRepository salesInvoiceRepository;

    @Mock
    private StallService stallService;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private SalesInvoiceService salesInvoiceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllSalesInvoices() {
        SalesInvoice invoice1 = new SalesInvoice();
        SalesInvoice invoice2 = new SalesInvoice();
        when(salesInvoiceRepository.findAll()).thenReturn(Arrays.asList(invoice1, invoice2));

        List<SalesInvoice> result = salesInvoiceService.getAllSalesInvoices();

        assertEquals(2, result.size());
        verify(salesInvoiceRepository, times(1)).findAll();
    }

    @Test
    public void testGetSalesInvoiceById() {
        SalesInvoice invoice = new SalesInvoice();
        when(salesInvoiceRepository.findById(1)).thenReturn(Optional.of(invoice));

        Optional<SalesInvoice> result = salesInvoiceService.getSalesInvoiceById(1);

        assertTrue(result.isPresent());
        assertEquals(invoice, result.get());
        verify(salesInvoiceRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveSalesInvoice() {
        SalesInvoice invoice = new SalesInvoice();
        when(salesInvoiceRepository.save(invoice)).thenReturn(invoice);

        SalesInvoice result = salesInvoiceService.saveSalesInvoice(invoice);

        assertEquals(invoice, result);
        verify(salesInvoiceRepository, times(1)).save(invoice);
    }

    @Test
    public void testDeleteSalesInvoice() {
        doNothing().when(salesInvoiceRepository).deleteById(1);

        salesInvoiceService.deleteSalesInvoice(1);

        verify(salesInvoiceRepository, times(1)).deleteById(1);
    }

    @Test
    public void testGetRevenueByStall() {
        Stall stall1 = new Stall();
        stall1.setStallId(1);
        Stall stall2 = new Stall();
        stall2.setStallId(2);
        when(stallService.getAllStalls()).thenReturn(Arrays.asList(stall1, stall2));
        when(salesInvoiceRepository.getTotalRevenueByStallId(1)).thenReturn(BigDecimal.valueOf(100));
        when(salesInvoiceRepository.getTotalRevenueByStallId(2)).thenReturn(BigDecimal.valueOf(200));

        Map<Stall, BigDecimal> result = salesInvoiceService.getRevenueByStall();

        assertEquals(BigDecimal.valueOf(100), result.get(stall1));
        assertEquals(BigDecimal.valueOf(200), result.get(stall2));
        verify(stallService, times(1)).getAllStalls();
        verify(salesInvoiceRepository, times(1)).getTotalRevenueByStallId(1);
        verify(salesInvoiceRepository, times(1)).getTotalRevenueByStallId(2);
    }

    @Test
    public void testGetRevenueByEmployee() {
        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        Employee employee2 = new Employee();
        employee2.setEmployeeId(2);
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));
        when(salesInvoiceRepository.getTotalRevenueByEmployeeId(1)).thenReturn(BigDecimal.valueOf(150));
        when(salesInvoiceRepository.getTotalRevenueByEmployeeId(2)).thenReturn(BigDecimal.valueOf(250));

        Map<Employee, BigDecimal> result = salesInvoiceService.getRevenueByEmployee();

        assertEquals(BigDecimal.valueOf(150), result.get(employee1));
        assertEquals(BigDecimal.valueOf(250), result.get(employee2));
        verify(employeeService, times(1)).getAllEmployees();
        verify(salesInvoiceRepository, times(1)).getTotalRevenueByEmployeeId(1);
        verify(salesInvoiceRepository, times(1)).getTotalRevenueByEmployeeId(2);
    }

    @Test
    public void testGetTotalRevenue() {
        SalesInvoice invoice1 = new SalesInvoice();
        invoice1.setTotalAmount(BigDecimal.valueOf(300));
        invoice1.setDiscount(BigDecimal.valueOf(50));
        SalesInvoice invoice2 = new SalesInvoice();
        invoice2.setTotalAmount(BigDecimal.valueOf(400));
        invoice2.setDiscount(BigDecimal.valueOf(100));
        when(salesInvoiceRepository.findAll()).thenReturn(Arrays.asList(invoice1, invoice2));

        BigDecimal result = salesInvoiceService.getTotalRevenue();

        assertEquals(BigDecimal.valueOf(550), result);
        verify(salesInvoiceRepository, times(1)).findAll();
    }

    @Test
    public void testCountSalesInvoices() {
        when(salesInvoiceRepository.count()).thenReturn(5L);

        long result = salesInvoiceService.countSalesInvoices();

        assertEquals(5L, result);
        verify(salesInvoiceRepository, times(1)).count();
    }
}