package com.vn.jewelry_management_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "SalesInvoice")
public class SalesInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalesInvoiceID")
    private int salesInvoiceId;

    @Column(name = "CreatedDate", nullable = false)
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "StallID")
    private Stall stall;

    @Column(name = "TotalAmount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "Discount")
    private BigDecimal discount;

    @Column(name = "PaymentMethod", nullable = false)
    private String paymentMethod;

    @OneToMany(mappedBy = "salesInvoice")
    private List<SalesInvoiceDetail> salesInvoiceDetails;

    // Constructors, Getters, and Setters

    public SalesInvoice() {
    }

    public SalesInvoice(LocalDateTime createdDate, Customer customer, Employee employee, Stall stall, BigDecimal totalAmount, BigDecimal discount, String paymentMethod) {
        this.createdDate = createdDate;
        this.customer = customer;
        this.employee = employee;
        this.stall = stall;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.paymentMethod = paymentMethod;
    }

    public int getSalesInvoiceId() {
        return salesInvoiceId;
    }

    public void setSalesInvoiceId(int salesInvoiceId) {
        this.salesInvoiceId = salesInvoiceId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Stall getStall() {
        return stall;
    }

    public void setStall(Stall stall) {
        this.stall = stall;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<SalesInvoiceDetail> getSalesInvoiceDetails() {
        return salesInvoiceDetails;
    }

    public void setSalesInvoiceDetails(List<SalesInvoiceDetail> salesInvoiceDetails) {
        this.salesInvoiceDetails = salesInvoiceDetails;
    }
}