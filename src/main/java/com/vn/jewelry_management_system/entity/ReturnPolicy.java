package com.vn.jewelry_management_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "ReturnPolicy")
public class ReturnPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReturnPolicyID")
    private int returnPolicyId;

    @Column(name = "ConditionReturn", nullable = false, columnDefinition = "TEXT")
    private String conditionReturn;

    @Column(name = "Duration", nullable = false)
    private int duration;

    // Constructors, Getters, and Setters

    public ReturnPolicy() {
    }

    public ReturnPolicy(String conditionReturn, int duration) {
        this.conditionReturn = conditionReturn;
        this.duration = duration;
    }

    public int getReturnPolicyId() {
        return returnPolicyId;
    }

    public void setReturnPolicyId(int returnPolicyId) {
        this.returnPolicyId = returnPolicyId;
    }

    public String getConditionReturn() {
        return conditionReturn;
    }

    public void setConditionReturn(String conditionReturn) {
        this.conditionReturn = conditionReturn;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}