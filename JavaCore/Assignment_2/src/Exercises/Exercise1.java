package Exercises;

import Entities.*;

import java.util.Objects;

import static Entities.PositionName.DEV;

public class Exercise1 {
    public static void checkDepartment(Account account) {
        Department department = account.getDepartment();
        if (Objects.isNull(account)) {
            System.out.println("NV ch co phong ban");
        } else {
            System.out.println("Phong ban nv: " + department.getDepartmentName());
        }
    }

    public static void question2(Account account, GroupAccount[] groupAccounts) {
        if(Objects.isNull(account)) return;
        if(Objects.isNull(groupAccounts)) return;
        int count = 0;
        for (GroupAccount groupAccount : groupAccounts) {
            if (groupAccount.getAccount() == account) {
                count++;
            }
        }
        if (count < 3) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (count == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }

    public static void question3(Account account) {
        Department department = account.getDepartment();
        System.out.println(department == null ?
                "NV ch co phong ban" : "Phong ban nv: " + department.getDepartmentName());
    }

    public static void question4(Account account) {
        System.out.println(DEV.equals(account.getPosition().getPositionName()) ?
                "Day la DEV" : "Nguoi nay khong phai DEV");
    }

    public static void question5(Group group, GroupAccount[] groupAccounts) {
        int count = 0;
        for (int i = 0; i < groupAccounts.length; i++) {
            if (group == groupAccounts[i].getGroup()) {
                count++;
            }
        }
        switch (count) {
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
        }
    }

    public static void question6(Account account, GroupAccount[] groupAccounts) {
        int count = 0;
        for (GroupAccount groupAccount : groupAccounts) {
            if (account == groupAccount.getAccount()) {
                count++;
            }
        }
        switch (count) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }

    public static void question7(Account account) {
        switch (account.getPosition().getPositionName()) {
            case DEV:
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
        }
    }

    public static void question8(Account[] accounts) {
        for(Account account: accounts){
            System.out.println(account.getEmail() + ", " + account.getFullname() +
                    ", " + account.getDepartment().getDepartmentName());
        }
    }

    public static void question9(Department[] departments) {
        for(Department department: departments){
            System.out.println(department.getDepartmentID() + ", " + department.getDepartmentName());
        }
    }

    public static void question10(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Thông tin account thứ " + (i+1) + " là:");
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full name: " + accounts[i].getFullname());
            System.out.println("Phong ban: " + accounts[i].getDepartment().getDepartmentName());
            System.out.println("//======================================================//");
        }
    }
    public static void question11(Department[] departments) {
        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thông tin department thứ " + (i+1) + " là:");
            System.out.println("ID: " + departments[i].getDepartmentID());
            System.out.println("name: " + departments[i].getDepartmentName());
            System.out.println("//======================================================//");
        }
    }
    public static void question12(Department[] departments) {
        for (int i = 0; i < 2; i++) {
            System.out.println("Thông tin department thứ " + (i+1) + " là:");
            System.out.println("ID: " + departments[i].getDepartmentID());
            System.out.println("name: " + departments[i].getDepartmentName());
            System.out.println("//======================================================//");
        }
    }
    public static void question13(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            if(i == 2) continue;
            System.out.println("Thông tin account thứ " +(i+1) + " là:");
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full name: " + accounts[i].getFullname());
            System.out.println("Phong ban: " + accounts[i].getDepartment().getDepartmentName());
            System.out.println("//======================================================//");
        }
    }
    public static void question14(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i].getAccountID() < 4){
                System.out.println("Thông tin account thứ " + (i+1) + " là:");
                System.out.println("Email: " + accounts[i].getEmail());
                System.out.println("Full name: " + accounts[i].getFullname());
                System.out.println("Phong ban: " + accounts[i].getDepartment().getDepartmentName());
                System.out.println("//======================================================//");
            }
        }
    }
    public static void question15(){
        for(int i = 0; i <= 20; i+=2){
            System.out.println(i);
        }
    }
}
