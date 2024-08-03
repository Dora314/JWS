package com.vn.jewelry_management_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SalesInvoiceDetail")
public class SalesInvoiceDetail {

  @EmbeddedId
  private SalesInvoiceDetailId id = new SalesInvoiceDetailId();

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("salesInvoiceId")
  @JoinColumn(name = "SalesInvoiceID")
  private SalesInvoice salesInvoice;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("productId")
  @JoinColumn(name = "ProductID")
  private Product product;

  @Column(name = "Quantity", nullable = false)
  private int quantity;

  @Column(name = "UnitPrice", nullable = false)
  private BigDecimal unitPrice;

  // Constructors, Getters, and Setters

  public SalesInvoiceDetail() {
  }

  public SalesInvoiceDetail(SalesInvoice salesInvoice, Product product, int quantity, BigDecimal unitPrice) {
    this.salesInvoice = salesInvoice;
    this.product = product;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
  }

  public SalesInvoiceDetailId getId() {
    return id;
  }

  public void setId(SalesInvoiceDetailId id) {
    this.id = id;
  }

  public SalesInvoice getSalesInvoice() {
    return salesInvoice;
  }

  public void setSalesInvoice(SalesInvoice salesInvoice) {
    this.salesInvoice = salesInvoice;
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
class SalesInvoiceDetailId implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "SalesInvoiceID")
  private int salesInvoiceId;

  @Column(name = "ProductID")
  private int productId;

  // Constructors, Getters, and Setters

  public SalesInvoiceDetailId() {
  }

  public SalesInvoiceDetailId(int salesInvoiceId, int productId) {
    this.salesInvoiceId = salesInvoiceId;
    this.productId = productId;
  }

  public int getSalesInvoiceId() {
    return salesInvoiceId;
  }

  public void setSalesInvoiceId(int salesInvoiceId) {
    this.salesInvoiceId = salesInvoiceId;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }
}