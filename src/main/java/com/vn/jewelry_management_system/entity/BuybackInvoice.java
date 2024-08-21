package com.vn.jewelry_management_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "BuybackInvoice")
public class BuybackInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BuybackInvoiceID")
    private int buybackInvoiceId;

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

    @OneToMany(mappedBy = "buybackInvoice")
    private List<BuybackInvoiceDetail> buybackInvoiceDetails;

    // Constructors, Getters, and Setters

    public BuybackInvoice() {
    }

    public BuybackInvoice(LocalDateTime createdDate, Customer customer, Employee employee, Stall stall, BigDecimal totalAmount) {
        this.createdDate = createdDate;
        this.customer = customer;
        this.employee = employee;
        this.stall = stall;
        this.totalAmount = totalAmount;
    }

    public int getBuybackInvoiceId() {
        return buybackInvoiceId;
    }

    public void setBuybackInvoiceId(int buybackInvoiceId) {
        this.buybackInvoiceId = buybackInvoiceId;
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

    public List<BuybackInvoiceDetail> getBuybackInvoiceDetails() {
        return buybackInvoiceDetails;
    }

    public void setBuybackInvoiceDetails(List<BuybackInvoiceDetail> buybackInvoiceDetails) {
        this.buybackInvoiceDetails = buybackInvoiceDetails;
    }
}