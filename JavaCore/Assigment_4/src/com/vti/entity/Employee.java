package com.vti.entity;

public class Employee extends User{
    @Override
    public double calculatePay() {
        return this.getSalaryRatio() * 420;
    }
}
