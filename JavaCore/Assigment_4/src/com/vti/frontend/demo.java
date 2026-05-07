package com.vti.frontend;

import com.vti.backend.Exercise1;
import com.vti.backend.QuanLiCanBo;
import com.vti.entity.HighSchoolStudent;
import com.vti.entity.Person;
import com.vti.entity.Student;

public class demo {
    public static void main(String[] args) {
//        Exercise1 exercise1 = new Exercise1();
//        exercise1.question1();
//        exercise1.question2();
//        exercise1.question3();
//        Student student = new Student("Nguyen Van A","tp HCM");
//        student.setDiemHocLuc(6.5);
//        System.out.println(student.getDiemHocLuc());
//        student.congDiem(1.0);
//        System.out.println(student.getDiemHocLuc());
//        System.out.println(student);
        question4();
    }
    public static void question4(){
        QuanLiCanBo quanLiCanBo = new QuanLiCanBo();
        quanLiCanBo.menu();
    }
    public static void question5(){
        Person highSchoolStudent = new HighSchoolStudent("nam",1,"Chuyen van", "DH cong nghe");
    }
}
