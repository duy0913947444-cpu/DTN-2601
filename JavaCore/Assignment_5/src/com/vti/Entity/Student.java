package com.vti.Entity;

public class Student implements IStudent{
    private int ID;
    private String name;
    private int group;

    public Student(int ID, String name, int group) {
        this.ID = ID;
        this.name = name;
        this.group = group;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public void diemDanh() {
        System.out.println(this.name + " diem danh");
    }

    @Override
    public void hocBai() {
        System.out.println(this.name + " dang hoc bai");
    }

    @Override
    public void donVS() {
        System.out.println(this.name + " dang don ve sinh");
    }

}
