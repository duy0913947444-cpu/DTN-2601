package org.example.Utils;



import org.example.Frontend.AccountFunction;
import org.example.Frontend.DepartmentFunction;
import org.example.Frontend.PositionFunction;

import java.util.Objects;
import java.util.Scanner;

public class Utils {
    private static Scanner sc = new Scanner(System.in);
    public static boolean checkString(String s){
        return Objects.isNull(s) || s.isEmpty() || " ".equals(s);
    }
    private AccountFunction accountFunction = new AccountFunction();
    private DepartmentFunction departmentFunction = new DepartmentFunction();
    private PositionFunction positionFunction = new PositionFunction();

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
