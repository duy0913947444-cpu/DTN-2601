package org.example.Utils;



import org.example.Frontend.AccountFunction;
import org.example.Frontend.DepartmentFunction;
import org.example.Frontend.PositionFunction;

import java.util.Objects;
import java.util.Scanner;

public class Utils {
    private static Scanner sc = new Scanner(System.in);
    private AccountFunction accountFunction = new AccountFunction();
    private DepartmentFunction departmentFunction = new DepartmentFunction();
    private PositionFunction positionFunction = new PositionFunction();

    public static boolean checkString(String s){
        return Objects.isNull(s) || s.trim().isEmpty();
    }

    public static boolean checkEmail(String email){
        if("@".equals(String.valueOf(email.charAt(0))) ||
                "@".equals(String.valueOf(email.charAt(email.length()-1)))){
            return false;
        }
        String[] strings = email.split("@");
        if(strings.length == 2){
            return true;
        }else{
            return false;
        }
    }
    public void menu(){
        do{
            System.out.println("Nhap chuc nang: ");
            System.out.println("1. Account");
            System.out.println("2. Department");
            System.out.println("3. Position");
            System.out.println("Other. Exit");
            String choose = sc.nextLine();
            switch (choose){
                case "1":
                    accountFunction.menu();
                    break;
                case "2":
                    departmentFunction.menu();
                    break;
                case "3":
                    positionFunction.menu();
                    break;
                default:
                    return;
            }
        }while(true);
    }
}
