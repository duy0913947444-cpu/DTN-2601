package com.vti.entity;

import com.vti.Enums.Gender;
import com.vti.Enums.Level;

public class CongNhan extends CanBo{
    private Level level;

    public CongNhan(String name, int age, Gender gender, String address, Level level) {
        super(name, age, gender, address);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "CongNhan{" + super.toString() +
                ", level=" + level +
                '}';
    }
}
