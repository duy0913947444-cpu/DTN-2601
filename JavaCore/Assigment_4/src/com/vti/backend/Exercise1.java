package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.Enums.PositionName;

import java.time.LocalDate;

public class Exercise1 {
    public void question1() {
        Department department = new Department();
        Department department1 = new Department("abc");
    }

    public void question2() {
        // Giả sử chúng ta đã có object cho Department và Position
        Department devDept = new Department("DEV");
        Position devPos = new Position(PositionName.PM);
        Account acc1 = new Account();
        Account acc2 = new Account(1, "test1@gmail.com", "user1", "Nguyen Van A", devDept, devPos, LocalDate.of(2023, 10, 1), 20000000);
        Account acc3 = new Account(2, "test2@gmail.com", "user2", "Tran", "Thi B");
        Account acc4 = new Account(3, "test3@gmail.com", "user3", "Le", "Van C", devDept, devPos, 25000000);
    }
    public static void question3 (){
        Account creator = new Account(1, "admin@gmail.com", "admin", "Nguyen", "Van Admin");
        Account acc1 = new Account(10, "user1@gmail.com", "user1", "Nguyen", "An");
        Account acc2 = new Account(11, "user2@gmail.com", "user2", "Le", "Binh");
        Account[] accountArray = {acc1, acc2};
        String[] usernames = {"vinh_dep_trai", "long_hao_hoa", "tuan_tai_ba"};
        Group group1 = new Group();
        Group group2 = new Group(1, "Nhóm Học Thuật", creator, LocalDate.now(), accountArray);
        Group group3 = new Group(2, "Nhóm Game", creator, LocalDate.now(), usernames);
    }
}
