package com.vn.jewelry_management_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PromotionID")
    private int promotionId;

    @Column(name = "PromotionName", nullable = false)
    private String promotionName;

    @Column(name = "PromotionType", nullable = false)
    private String promotionType;

    @Column(name = "ConditionPromotion")
    private String conditionPromotion;

    @Column(name = "Value", nullable = false)
    private BigDecimal value;

    @Column(name = "StartDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "EndDate", nullable = false)
    private LocalDate endDate;

    // Constructors, Getters, and Setters

    public Promotion() {
    }

    public Promotion(String promotionName, String promotionType, String conditionPromotion, BigDecimal value, LocalDate startDate, LocalDate endDate) {
        this.promotionName = promotionName;
        this.promotionType = promotionType;
        this.conditionPromotion = conditionPromotion;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public String getConditionPromotion() {
        return conditionPromotion;
    }

    public void setConditionPromotion(String conditionPromotion) {
        this.conditionPromotion = conditionPromotion;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}