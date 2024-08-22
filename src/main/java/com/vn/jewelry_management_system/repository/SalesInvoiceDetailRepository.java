package com.vn.jewelry_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vn.jewelry_management_system.domain.SalesInvoiceDetail;
import com.vn.jewelry_management_system.domain.SalesInvoiceDetailId;

@Repository
public interface SalesInvoiceDetailRepository extends JpaRepository<SalesInvoiceDetail, SalesInvoiceDetailId> {
    // Không cần phương thức findBy... vì SalesInvoiceDetailId đã là khóa chính
}