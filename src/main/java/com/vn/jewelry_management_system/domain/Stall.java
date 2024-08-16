package com.vn.jewelry_management_system.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stallId;

    private String stallName;
    private String location;

    // Constructors, Getters and Setters

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

    @Override
    public String toString() {
        return "Stall [stallId=" + stallId + ", stallName=" + stallName + ", location=" + location + "]";
    }
}
