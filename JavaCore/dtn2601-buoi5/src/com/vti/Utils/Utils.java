package com.vti.Utils;

import com.vti.Frontend.AccountFunction;
import com.vti.Frontend.DepartmentFunction;
import com.vti.Frontend.PositionFunction;

import java.util.Objects;
import java.util.Scanner;

public class Utils {
    private static Scanner sc = new Scanner(System.in);
    public static boolean checkString(String s){
        return Objects.isNull(s) || s.isEmpty() || " ".equals(s);
    }
    public static void menu(){
        do{
            System.out.println("Nhap chuc nang: ");
            System.out.println("1. Account");
            System.out.println("2. Department");
            System.out.println("3. Position");
            System.out.println("Other. Exit");
            String choose = sc.nextLine();
            switch (choose){
                case "1":
                    AccountFunction.menu();
                    break;
                case "2":
                    DepartmentFunction.menu();
                    break;
                case "3":
                    PositionFunction.menu();
                    break;
                default:
                    return;
            }
        }while(true);
    }
}
