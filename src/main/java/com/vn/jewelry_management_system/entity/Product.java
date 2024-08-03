package com.vn.jewelry_management_system.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Long productId;

    @Column(name = "ProductName", nullable = false)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private ProductCategory productCategory;

    @Column(name = "Weight", nullable = false)
    private Double weight;

    @Column(name = "Material", nullable = false)
    private String material;

    @Column(name = "MakingFee", nullable = false)
    private Double makingFee;

    @Column(name = "GemstonePrice")
    private Double gemstonePrice;

    @Column(name = "CostPrice", nullable = false)
    private Double costPrice;

    @Column(name = "MarkupRatio", nullable = false)
    private Double markupRatio;

    @Column(name = "Image")
    private String image;

    @Column(name = "Status", nullable = false)
    private boolean status;

    // Constructors, Getters, and Setters

    public Product() {
    }

    public Product(String productName, ProductCategory productCategory, Double weight, String material, Double makingFee, Double gemstonePrice, Double costPrice, Double markupRatio, String image, boolean status) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.weight = weight;
        this.material = material;
        this.makingFee = makingFee;
        this.gemstonePrice = gemstonePrice;
        this.costPrice = costPrice;
        this.markupRatio = markupRatio;
        this.image = image;
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getMakingFee() {
        return makingFee;
    }

    public void setMakingFee(Double makingFee) {
        this.makingFee = makingFee;
    }

    public Double getGemstonePrice() {
        return gemstonePrice;
    }

    public void setGemstonePrice(Double gemstonePrice) {
        this.gemstonePrice = gemstonePrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getMarkupRatio() {
        return markupRatio;
    }

    public void setMarkupRatio(Double markupRatio) {
        this.markupRatio = markupRatio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}