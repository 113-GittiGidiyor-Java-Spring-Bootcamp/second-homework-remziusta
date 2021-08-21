package com.work.spring.model;

import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor{
    private Double fixedSalary;

    public PermanentInstructor() {
    }

    public PermanentInstructor(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(String name, String address, String phoneNumber, Double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public Double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
