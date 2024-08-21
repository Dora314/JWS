package com.vn.jewelry_management_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CustomerPolicy")
public class CustomerPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PolicyID")
    private int policyId;

    @Column(name = "PolicyName", nullable = false)
    private String policyName;

    @Column(name = "CustomerType", nullable = false)
    private String customerType;

    @Column(name = "DiscountRate", nullable = false)
    private BigDecimal discountRate;

    // Constructors, Getters, and Setters

    public CustomerPolicy() {
    }

    public CustomerPolicy(String policyName, String customerType, BigDecimal discountRate) {
        this.policyName = policyName;
        this.customerType = customerType;
        this.discountRate = discountRate;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }
}