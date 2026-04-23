package Exercises;

import Entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Exercise5 {
    public static Random rd = new Random();
    public static Scanner sc = new Scanner(System.in);
    public static void question1(){
        int a,b,c;
        System.out.println("Nhap a,b,c:");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
    }
    public static void quesiton2(){
        float a,b;
        System.out.println("Nhap 2 so thuc: ");
        a = sc.nextFloat();
        b = sc.nextFloat();
        sc.nextLine();
    }
    public static void question3(){
        System.out.println("Nhap ho va ten:");
        String name = sc.nextLine();
    }
    public static void question4(){
        System.out.println("Nhap birthday:");
        String birthday = sc.nextLine();
    }
    public static Account question5(){
        Account account = new Account();
        System.out.println("Nhap email: ");
        account.setEmail(sc.nextLine());
        System.out.println("Nhap userName: ");
        account.setUserName(sc.nextLine());
        System.out.println("Nhap fullName: ");
        account.setFullname(sc.nextLine());
        System.out.println("Nhap department name: ");
        Department department = new Department(sc.nextLine());
        account.setDepartment(department);
        System.out.println("Nhap position: 1.dev, 2.test, 3.ScrumMaster, 4.PM");
        int choice = sc.nextInt();
        Position position = new Position();
        switch (choice){
            case 1:
                position.setPositionName(PositionName.DEV);
                break;
            case 2:
                position.setPositionName(PositionName.TEST);
                break;
            case 3:
                position.setPositionName(PositionName.SCRUM_MASTER);
                break;
            case 4:
                position.setPositionName(PositionName.PM);
                break;
        }
        account.setPosition(position);
        System.out.println("Nhap createDate: ");
        System.out.println("Nhap ngay");
        int day = sc.nextInt();
        System.out.println("Nhap month:");
        int month = sc.nextInt();
        System.out.println("Nhap year:");
        int year = sc.nextInt();
        LocalDate createDate = LocalDate.of(year,month,day);
        sc.nextLine();
        return  account;
    }
    public static Department question6(){
        Department department = new Department();
        System.out.println("Nhap department name:");
        department.setDepartmentName(sc.nextLine());
        return department;
    }
    public static void question7(){
        int n;
        do{
            System.out.println("Nhap so chan khong dung nhap lai:");
            n = sc.nextInt();
        }while(n%2 != 0);
    }
    public static void question8(){
        int choice;
        do{
            System.out.println("mời bạn nhập vào chức năng muốn sử dụng");
            System.out.println("1 thì sẽ thực hiện tạo account");
            System.out.println(" 2 thì sẽ thực hiện chức năng tạo department");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    Account account = question5();
                    break;
                case 2:
                    Department department = question6();
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
            if(choice == 1 || choice == 2)
                break;
        }while(true);
    }
    public static GroupAccount question9(Account[] accounts, Group[] groups){
        for(Account account: accounts){
            System.out.println(account.getUserName());
        }
        Account accountInput = null;
        System.out.println("Nhap vao ten user: ");
        String userName = sc.nextLine();
        for(Account account: accounts){
            if (account.getUserName().equals(userName)){
                accountInput = account;
                break;
            }
        }
        for(Group group: groups){
            System.out.println(group.getGroupName());
        }
        Group groupInput = null;
        System.out.println("Nhap ten group de join: ");
        String groupName = sc.nextLine();
        for(Group group: groups){
            if (group.getGroupName().equals(groupName)){
                groupInput = group;
                break;
            }
        }
        return new GroupAccount(groupInput, accountInput, LocalDate.now());
    }
    public static void question10(Account[] accounts, Group[] groups){
        int choice;
        do{
            System.out.println("mời bạn nhập vào chức năng muốn sử dụng");
            System.out.println(" 1 thì sẽ thực hiện tạo account");
            System.out.println(" 2 thì sẽ thực hiện chức năng tạo department");
            System.out.println(" 3 them group");
            System.out.println(" 4 them group ngau nhien");
            System.out.println(" 5 tiep tuc hoac thoat chuong trinh");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    Account account = question5();
                    break;
                case 2:
                    Department department = question6();
                    break;
                case 3:
                    GroupAccount groupAccount = question9(accounts,groups);
                    break;
                case 4:
                    GroupAccount groupAccount1 = question11(accounts,groups);
                    break;
                case 5:
                    System.out.println("Ban co muon tiep tuc chuong trinh khong: yes/no");
                    String input = sc.nextLine();
                    if("no".equals(input.toLowerCase())){
                        return;
                    }
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
            if(choice == 1 || choice == 2)
                break;
        }while(true);
    }
    public static GroupAccount question11(Account[] accounts, Group[] groups){
        for(Account account: accounts){
            System.out.println(account.getUserName());
        }
        Account accountInput = null;
        System.out.println("Nhap vao ten user: ");
        String userName = sc.nextLine();
        for(Account account: accounts){
            if (account.getUserName().equals(userName)){
                accountInput = account;
                break;
            }
        }
        return new GroupAccount(groups[rd.nextInt(groups.length)], accountInput, LocalDate.now());
    }
}
