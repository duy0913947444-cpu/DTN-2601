package com.vti.entity;

public class Waiter extends User{
    @Override
    public double calculatePay() {
        return this.getSalaryRatio() * 220;
    }
}
