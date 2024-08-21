package com.vn.jewelry_management_system.service;

import org.springframework.stereotype.Service;
import com.vn.jewelry_management_system.domain.SalesInvoiceDetail;
import com.vn.jewelry_management_system.domain.SalesInvoiceDetailId;
import com.vn.jewelry_management_system.repository.SalesInvoiceDetailRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalesInvoiceDetailService {
    private final SalesInvoiceDetailRepository salesInvoiceDetailRepository;

    public SalesInvoiceDetailService(SalesInvoiceDetailRepository salesInvoiceDetailRepository) {
        this.salesInvoiceDetailRepository = salesInvoiceDetailRepository;
    }

    public List<SalesInvoiceDetail> getAllSalesInvoiceDetails() {
        return salesInvoiceDetailRepository.findAll();
    }

    public Optional<SalesInvoiceDetail> getSalesInvoiceDetailById(SalesInvoiceDetailId id) {
        return salesInvoiceDetailRepository.findById(id);
    }

    public SalesInvoiceDetail saveSalesInvoiceDetail(SalesInvoiceDetail salesInvoiceDetail) {
        return salesInvoiceDetailRepository.save(salesInvoiceDetail);
    }

    public void deleteSalesInvoiceDetail(SalesInvoiceDetailId id) {
        salesInvoiceDetailRepository.deleteById(id);
    }
}