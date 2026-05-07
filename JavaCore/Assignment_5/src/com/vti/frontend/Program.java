package com.vti.frontend;

import com.vti.Entity.Student;
import com.vti.backend.MyNews;

public class Program {
    public static void main(String[] args) {
        MyNews myNews = new MyNews();
        myNews.menu();
        Student[] students = new Student[10];
        students[0] = new Student(1, "Nguyễn Văn A", 1);
        students[1] = new Student(2, "Trần Thị B", 2);
        students[2] = new Student(3, "Lê Văn C", 3);
        students[3] = new Student(4, "Phạm Văn D", 1);
        students[4] = new Student(5, "Hoàng Thị E", 2);
        students[5] = new Student(6, "Vũ Văn F", 3);
        students[6] = new Student(7, "Đỗ Thị G", 1);
        students[7] = new Student(8, "Bùi Văn H", 2);
        students[8] = new Student(9, "Lý Thị I", 1);
        students[9] = new Student(10, "Phan Văn K", 3);

        // b) Kêu gọi cả lớp điểm danh
        System.out.println("--- Cả lớp điểm danh ---");
        for (Student s : students) {
            s.diemDanh();
        }

        // c) Gọi nhóm 1 đi học bài
        System.out.println("\n--- Nhóm 1 đi học bài ---");
        for (Student s : students) {
            if (s.getGroup() == 1) {
                s.hocBai();
            }
        }

        // d) Gọi nhóm 2 đi dọn vệ sinh
        System.out.println("\n--- Nhóm 2 đi dọn vệ sinh ---");
        for (Student s : students) {
            if (s.getGroup() == 2) {
                s.donVS();
            }
        }
    }
}
