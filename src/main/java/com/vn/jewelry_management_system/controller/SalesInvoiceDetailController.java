package com.vn.jewelry_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.vn.jewelry_management_system.domain.SalesInvoiceDetail;
import com.vn.jewelry_management_system.domain.SalesInvoiceDetailId;
import com.vn.jewelry_management_system.service.ProductService;
import com.vn.jewelry_management_system.service.SalesInvoiceDetailService;
import com.vn.jewelry_management_system.service.SalesInvoiceService;
import java.util.Optional;

@Controller
@RequestMapping("/admin/sales-invoice-details")
public class SalesInvoiceDetailController {
    private final SalesInvoiceDetailService salesInvoiceDetailService;
    private final SalesInvoiceService salesInvoiceService;
    private final ProductService productService;

    public SalesInvoiceDetailController(SalesInvoiceDetailService salesInvoiceDetailService,
            SalesInvoiceService salesInvoiceService, ProductService productService) {
        this.salesInvoiceDetailService = salesInvoiceDetailService;
        this.salesInvoiceService = salesInvoiceService;
        this.productService = productService;
    }

    @GetMapping
    public String showAllSalesInvoiceDetails(Model model) {
        model.addAttribute("salesInvoiceDetails", salesInvoiceDetailService.getAllSalesInvoiceDetails());
        model.addAttribute("salesInvoices", salesInvoiceService.getAllSalesInvoices());
        model.addAttribute("products", productService.getAllProducts());
        return "admin/sales-invoice-detail/table-sales-invoice-detail";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("salesInvoiceDetail", new SalesInvoiceDetail());
        model.addAttribute("salesInvoices", salesInvoiceService.getAllSalesInvoices());
        model.addAttribute("products", productService.getAllProducts());
        return "admin/sales-invoice-detail/create";
    }

    @PostMapping("/create")
    public String createSalesInvoiceDetail(
            @ModelAttribute("salesInvoiceDetail") SalesInvoiceDetail salesInvoiceDetail) {
        // Lấy salesInvoiceId và productId từ form
        int salesInvoiceId = salesInvoiceDetail.getSalesInvoice().getSalesInvoiceId();
        int productId = salesInvoiceDetail.getProduct().getProductId();

        // Tạo SalesInvoiceDetailId
        SalesInvoiceDetailId salesInvoiceDetailId = new SalesInvoiceDetailId(salesInvoiceId, productId);

        // Set SalesInvoiceDetailId cho salesInvoiceDetail
        salesInvoiceDetail.setId(salesInvoiceDetailId);

        salesInvoiceDetailService.saveSalesInvoiceDetail(salesInvoiceDetail);
        return "redirect:/admin/sales-invoice-details";
    }

    @GetMapping("/edit/{salesInvoiceId}/{productId}")
    public String showEditForm(@PathVariable("salesInvoiceId") int salesInvoiceId,
            @PathVariable("productId") int productId, Model model) {
        SalesInvoiceDetailId salesInvoiceDetailId = new SalesInvoiceDetailId(salesInvoiceId, productId);
        Optional<SalesInvoiceDetail> salesInvoiceDetail = salesInvoiceDetailService
                .getSalesInvoiceDetailById(salesInvoiceDetailId);
        model.addAttribute("salesInvoiceDetail", salesInvoiceDetail.orElse(null));
        model.addAttribute("salesInvoices", salesInvoiceService.getAllSalesInvoices());
        model.addAttribute("products", productService.getAllProducts());
        return "admin/sales-invoice-detail/edit";
    }

    @PostMapping("/edit/{salesInvoiceId}/{productId}")
    public String updateSalesInvoiceDetail(@PathVariable("salesInvoiceId") int salesInvoiceId,
            @PathVariable("productId") int productId,
            @ModelAttribute("salesInvoiceDetail") SalesInvoiceDetail salesInvoiceDetail) {
        // Tạo SalesInvoiceDetailId
        SalesInvoiceDetailId salesInvoiceDetailId = new SalesInvoiceDetailId(salesInvoiceId, productId);
        // Set SalesInvoiceDetailId cho salesInvoiceDetail
        salesInvoiceDetail.setId(salesInvoiceDetailId);

        salesInvoiceDetailService.saveSalesInvoiceDetail(salesInvoiceDetail);
        return "redirect:/admin/sales-invoice-details";
    }

    @GetMapping("/delete/{salesInvoiceId}/{productId}")
    public String deleteSalesInvoiceDetail(@PathVariable("salesInvoiceId") int salesInvoiceId,
            @PathVariable("productId") int productId) {
        SalesInvoiceDetailId salesInvoiceDetailId = new SalesInvoiceDetailId(salesInvoiceId, productId);
        salesInvoiceDetailService.deleteSalesInvoiceDetail(salesInvoiceDetailId);
        return "redirect:/admin/sales-invoice-details";
    }
}