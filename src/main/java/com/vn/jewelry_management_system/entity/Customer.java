package com.vn.jewelry_management_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CustomerID")
  private int customerId;

  @Column(name = "CustomerName", nullable = false)
  private String customerName;

  @Column(name = "Phone")
  private String phone;

  @Column(name = "Address")
  private String address;

  @Column(name = "Email")
  private String email;

  @Column(name = "LoyaltyPoint")
  private int loyaltyPoint;

  // Constructors, Getters, and Setters

  public Customer() {
  }

  public Customer(String customerName, String phone, String address, String email, int loyaltyPoint) {
    this.customerName = customerName;
    this.phone = phone;
    this.address = address;
    this.email = email;
    this.loyaltyPoint = loyaltyPoint;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getLoyaltyPoint() {
    return loyaltyPoint;
  }

  public void setLoyaltyPoint(int loyaltyPoint) {
    this.loyaltyPoint = loyaltyPoint;
  }
}