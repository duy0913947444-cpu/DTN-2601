package com.vti.entity;

public class Student {
    private int id;
    private String name;
    private String hometown;
    private double diemHocLuc;

    //Constructor
    public Student(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
        this.diemHocLuc = 0;
    }

    public double getDiemHocLuc() {
        return diemHocLuc;
    }

    public void setDiemHocLuc(double diemHocLuc) {
        this.diemHocLuc = diemHocLuc;
    }
    public void congDiem(double diemCong){
        this.diemHocLuc += diemCong;
    }
    public String hocLuc(double diem){
        if(diem < 4 && diem >= 0){
            return "Yeu";
        }else if (diem < 6){
            return "Trung binh";
        }else if (diem < 8){
            return "Kha";
        }else if (diem <= 10){
            return "Gioi";
        }else{
            return "Diem ko hop le";
        }
    }
    @Override
    public String toString() {
        return "Student{" +
                "id= " + id +
                ", name='" + name + '\'' +
                ", hometown='" + hometown + '\'' +
                ", HocLuc: " + hocLuc(diemHocLuc) +
                '}';
    }
}
