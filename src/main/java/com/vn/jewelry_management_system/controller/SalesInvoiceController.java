package com.vn.jewelry_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.vn.jewelry_management_system.domain.Customer;
import com.vn.jewelry_management_system.domain.Employee;
import com.vn.jewelry_management_system.domain.SalesInvoice;
import com.vn.jewelry_management_system.domain.Stall;
import com.vn.jewelry_management_system.service.CustomerService;
import com.vn.jewelry_management_system.service.EmployeeService;
import com.vn.jewelry_management_system.service.SalesInvoiceService;
import com.vn.jewelry_management_system.service.StallService;

import java.util.Optional;

@Controller
@RequestMapping("/admin/sales-invoices")
public class SalesInvoiceController {
    private final SalesInvoiceService salesInvoiceService;
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final StallService stallService;

    public SalesInvoiceController(SalesInvoiceService salesInvoiceService, CustomerService customerService,
            EmployeeService employeeService, StallService stallService) {
        this.salesInvoiceService = salesInvoiceService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.stallService = stallService;
    }

    @GetMapping
    public String showAllSalesInvoices(Model model) {
        model.addAttribute("salesInvoices", salesInvoiceService.getAllSalesInvoices());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("stalls", stallService.getAllStalls());
        return "admin/sales-invoice/table-sales-invoice";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("salesInvoice", new SalesInvoice());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("stalls", stallService.getAllStalls());
        return "admin/sales-invoice/create";
    }

    @PostMapping("/create")
    public String createSalesInvoice(@ModelAttribute("salesInvoice") SalesInvoice salesInvoice) {
        salesInvoiceService.saveSalesInvoice(salesInvoice);
        return "redirect:/admin/sales-invoices";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Optional<SalesInvoice> salesInvoice = salesInvoiceService.getSalesInvoiceById(id);
        model.addAttribute("salesInvoice", salesInvoice.orElse(null));
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("stalls", stallService.getAllStalls());
        return "admin/sales-invoice/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateSalesInvoice(@PathVariable("id") int id,
            @ModelAttribute("salesInvoice") SalesInvoice salesInvoice) {
        salesInvoice.setSalesInvoiceId(id);
        salesInvoiceService.saveSalesInvoice(salesInvoice);
        return "redirect:/admin/sales-invoices";
    }

    @GetMapping("/delete/{id}")
    public String deleteSalesInvoice(@PathVariable("id") int id) {
        salesInvoiceService.deleteSalesInvoice(id);
        return "redirect:/admin/sales-invoices";
    }
}