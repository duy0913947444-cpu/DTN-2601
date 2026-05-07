package com.vti.Entity;

public class KhoiA extends ThiSinh {
    private String monThi = "Toan, Li, Hoa";

    public KhoiA(String SBD, String name, String address, String mucUuTien, String monThi) {
        super(SBD, name, address, mucUuTien);
        this.monThi = monThi;
    }


    @Override
    public String toString() {
        return "Thi sinh: " + super.displayInfor() + ", Khoi A {" +
                "monThi='" + monThi + '\'' +
                '}';
    }
}
