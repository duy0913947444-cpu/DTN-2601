package Exercises;

import Entities.Account;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Excercise2 {
    public static void questiopn1(){
        int number = 5;
        System.out.printf("%d\n", number);
    }
    public static void questiopn2(){
        int number = 1000000000;
        System.out.printf("%,d\n", number);
    }
    public static void questiopn3(){
        float number = 5.567098f;
        System.out.printf("%.4f\n", number);
    }
    public static void questiopn4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap name:");
        String name = sc.nextLine();
        System.out.println("Tên tôi là " + name + " và tôi đang độc thân.");
    }
    public static void questiopn5(){
        String datePattern = "dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }
    public static void questiopn6(Account[] accounts){
        System.out.printf("%-20s %-20s %-15s%n", "Email", "Full name", "Department name");
        System.out.println("-------------------------------------------------------------");
        for(Account account: accounts){
            System.out.printf("%-20s %-20s %-15s%n", account.getEmail(), account.getFullname()
                    , account.getDepartment().getDepartmentName());
        }
    }
}
