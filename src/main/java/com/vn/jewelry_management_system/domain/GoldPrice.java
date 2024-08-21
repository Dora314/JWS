package com.vn.jewelry_management_system.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class GoldPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goldPriceId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;

    private BigDecimal goldPrice;

    // Constructors, Getters and Setters

    public GoldPrice() {
    }

    public GoldPrice(Date updateDate, BigDecimal goldPrice) {
        this.updateDate = updateDate;
        this.goldPrice = goldPrice;
    }

    public int getGoldPriceId() {
        return goldPriceId;
    }

    public void setGoldPriceId(int goldPriceId) {
        this.goldPriceId = goldPriceId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public BigDecimal getGoldPrice() {
        return goldPrice;
    }

    public void setGoldPrice(BigDecimal goldPrice) {
        this.goldPrice = goldPrice;
    }

    @Override
    public String toString() {
        return "GoldPrice [goldPriceId=" + goldPriceId + ", updateDate=" + updateDate + ", goldPrice=" + goldPrice
                + "]";
    }

}