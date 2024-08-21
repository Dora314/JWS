package com.vn.jewelry_management_system.entity;

import javax.persistence.*;

import scala.collection.immutable.List;

@Entity
@Table(name = "Employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EmployeeID")
  private int employeeId;

  @Column(name = "EmployeeName", nullable = false)
  private String employeeName;

  @Column(name = "Phone")
  private String phone;

  @Column(name = "Address")
  private String address;

  @Column(name = "Position", nullable = false)
  private String position;

  @Column(name = "Salary", nullable = false)
  private double salary;

  // Relationships
  @ManyToOne
  @JoinColumn(name = "StallID")
  private Stall stall;

  @OneToMany(mappedBy = "employee")
  private List<SalesInvoice> salesInvoices;

  @OneToMany(mappedBy = "employee")
  private List<BuybackInvoice> buybackInvoices;

  // Constructors, Getters, and Setters

  public Employee() {
  }

  public Employee(String employeeName, String phone, String address, String position, double salary, Stall stall) {
    this.employeeName = employeeName;
    this.phone = phone;
    this.address = address;
    this.position = position;
    this.salary = salary;
    this.stall = stall;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
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

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public Stall getStall() {
    return stall;
  }

  public void setStall(Stall stall) {
    this.stall = stall;
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
}