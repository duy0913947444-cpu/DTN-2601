package com.vti.entity;

public class Manager extends User{
    @Override
    public double calculatePay() {
        return this.getSalaryRatio() * 520;
    }
}
