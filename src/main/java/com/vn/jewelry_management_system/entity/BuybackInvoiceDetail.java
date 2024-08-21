package com.vn.jewelry_management_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BuybackInvoiceDetail")
public class BuybackInvoiceDetail {

    @EmbeddedId
    private BuybackInvoiceDetailId id = new BuybackInvoiceDetailId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("buybackInvoiceId")
    @JoinColumn(name = "BuybackInvoiceID")
    private BuybackInvoice buybackInvoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "UnitPrice", nullable = false)
    private BigDecimal unitPrice;

    // Constructors, Getters, and Setters

    public BuybackInvoiceDetail() {
    }

    public BuybackInvoiceDetail(BuybackInvoice buybackInvoice, Product product, int quantity, BigDecimal unitPrice) {
        this.buybackInvoice = buybackInvoice;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters

    public BuybackInvoiceDetailId getId() {
        return id;
    }

    public void setId(BuybackInvoiceDetailId id) {
        this.id = id;
    }

    public BuybackInvoice getBuybackInvoice() {
        return buybackInvoice;
    }

    public void setBuybackInvoice(BuybackInvoice buybackInvoice) {
        this.buybackInvoice = buybackInvoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}

@Embeddable
class BuybackInvoiceDetailId implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "BuybackInvoiceID")
    private int buybackInvoiceId;

    @Column(name = "ProductID")
    private int productId;

    // Constructors, Getters, and Setters

    public BuybackInvoiceDetailId() {
    }

    public BuybackInvoiceDetailId(int buybackInvoiceId, int productId) {
        this.buybackInvoiceId = buybackInvoiceId;
        this.productId = productId;
    }

    // Getters and Setters

    public int getBuybackInvoiceId() {
        return buybackInvoiceId;
    }

    public void setBuybackInvoiceId(int buybackInvoiceId) {
        this.buybackInvoiceId = buybackInvoiceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}