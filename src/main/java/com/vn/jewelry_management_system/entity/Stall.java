package com.vn.jewelry_management_system.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Stall")
public class Stall {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "StallID")
  private int stallId;

  @Column(name = "StallName", nullable = false)
  private String stallName;

  @Column(name = "Location")
  private String location;

  // Relationships
  @OneToMany(mappedBy = "stall")
  private List<Employee> employees;

  @OneToMany(mappedBy = "stall")
  private List<SalesInvoice> salesInvoices;

  @OneToMany(mappedBy = "stall")
  private List<BuybackInvoice> buybackInvoices;

  @OneToMany(mappedBy = "stall")
  private List<Inventory> inventories;

  // Constructors, Getters, and Setters

  public Stall() {
  }

  public Stall(String stallName, String location) {
    this.stallName = stallName;
    this.location = location;
  }

  public int getStallId() {
    return stallId;
  }

  public void setStallId(int stallId) {
    this.stallId = stallId;
  }

  public String getStallName() {
    return stallName;
  }

  public void setStallName(String stallName) {
    this.stallName = stallName;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public List<SalesInvoice> getSalesInvoices() {
    return salesInvoices;
  }

  public void setSalesInvoices(List<SalesInvoice> salesInvoices) {
    this.salesInvoices = salesInvoices;
  }

  public List<BuybackInvoice> getBuybackInvoices() {
    return buybackInvoices;
  }

  public void setBuybackInvoices(List<BuybackInvoice> buybackInvoices) {
    this.buybackInvoices = buybackInvoices;
  }

  public List<Inventory> getInventories() {
    return inventories;
  }

  public void setInventories(List<Inventory> inventories) {
    this.inventories = inventories;
  }
}