package com.vti.entity;

public class HighSchoolStudent extends HocSinh{
    private String clazz;
    private String desiredUniversity;

    public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
        super(name, id);
        this.clazz = clazz;
        this.desiredUniversity = desiredUniversity;
    }
}
