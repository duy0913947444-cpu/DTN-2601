package com.vti.entity;

import com.vti.Enums.Gender;

public class NhanVien extends CanBo {
    private String position;

    public NhanVien(String name, int age, Gender gender, String address, String position) {
        super(name, age, gender, address);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "NhanVien{" + super.toString() +
                ", position='" + position + '\'' +
                '}';
    }
}
