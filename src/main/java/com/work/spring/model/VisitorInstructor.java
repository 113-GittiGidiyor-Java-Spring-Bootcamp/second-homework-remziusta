package com.work.spring.model;

import javax.persistence.Entity;

@Entity
public class VisitorInstructor extends Instructor{
    private Double hourlySalary;

    public VisitorInstructor(){}

    public VisitorInstructor(Double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitorInstructor(String name, String address, String phoneNumber, Double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public Double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(Double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
