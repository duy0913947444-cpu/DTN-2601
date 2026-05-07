package com.vti.Entity;

public class KhoiB extends ThiSinh{
    private String monThi = "Toan, Hoa, Sinh";

    public KhoiB(String SBD, String name, String address, String mucUuTien, String monThi) {
        super(SBD, name, address, mucUuTien);
        this.monThi = monThi;
    }


    @Override
    public String toString() {
        return "Thi sinh: " + super.displayInfor() + ", Khoi B {" +
                "monThi='" + monThi + '\'' +
                '}';
    }
}
