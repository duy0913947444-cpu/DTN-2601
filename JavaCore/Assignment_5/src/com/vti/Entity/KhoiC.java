package com.vti.Entity;

public class KhoiC extends ThiSinh{
    private String monThi = "Van, Su, Dia";

    public KhoiC(String SBD, String name, String address, String mucUuTien, String monThi) {
        super(SBD, name, address, mucUuTien);
        this.monThi = monThi;
    }


    @Override
    public String toString() {
        return "Thi sinh: " + super.displayInfor() + ", Khoi C {" +
                "monThi='" + monThi + '\'' +
                '}';
    }
}
