package com.vn.jewelry_management_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "GoldPrice")
public class GoldPrice {

    @Id
    @Column(name = "UpdateDate")
    private LocalDate updateDate;

    @Column(name = "GoldPrice", nullable = false)
    private BigDecimal goldPrice;

    // Constructors, Getters, and Setters

    public GoldPrice() {
    }

    public GoldPrice(LocalDate updateDate, BigDecimal goldPrice) {
        this.updateDate = updateDate;
        this.goldPrice = goldPrice;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public BigDecimal getGoldPrice() {
        return goldPrice;
    }

    public void setGoldPrice(BigDecimal goldPrice) {
        this.goldPrice = goldPrice;
    }
}