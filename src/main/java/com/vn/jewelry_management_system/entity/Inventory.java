package com.vn.jewelry_management_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "Inventory")
public class Inventory {

    @EmbeddedId
    private InventoryId id = new InventoryId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stallId")
    @JoinColumn(name = "StallID")
    private Stall stall;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    // Constructors, Getters, and Setters

    public Inventory() {
    }

    public Inventory(Stall stall, Product product, int quantity) {
        this.stall = stall;
        this.product = product;
        this.quantity = quantity;
    }

    public InventoryId getId() {
        return id;
    }

    public void setId(InventoryId id) {
        this.id = id;
    }

    public Stall getStall() {
        return stall;
    }

    public void setStall(Stall stall) {
        this.stall = stall;
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
}

@Embeddable
class InventoryId implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "StallID")
    private int stallId;

    @Column(name = "ProductID")
    private int productId;

    // Constructors, Getters, and Setters

    public InventoryId() {
    }

    public InventoryId(int stallId, int productId) {
        this.stallId = stallId;
        this.productId = productId;
    }

    public int getStallId() {
        return stallId;
    }

    public void setStallId(int stallId) {
        this.stallId = stallId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}