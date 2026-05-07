package com.vti.Entity;

public class ThiSinh {
    private String SBD;
    private String name;
    private String address;
    private String mucUuTien;

    public ThiSinh(String SBD, String name, String address, String mucUuTien) {
        this.SBD = SBD;
        this.name = name;
        this.address = address;
        this.mucUuTien = mucUuTien;
    }

    public String displayInfor() {
       return "SBD: " + SBD + ", Họ tên: " + name +
                ", Địa chỉ: " + address + ", Ưu tiên: " + mucUuTien;
    }
}
