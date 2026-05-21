package org.example.Utils;



import org.example.Frontend.AccountFunction;
import org.example.Frontend.DepartmentFunction;
import org.example.Frontend.PositionFunction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if(Objects.nonNull(connection)){
                connection.close();
            }else if(Objects.nonNull(statement)){
                statement.close();
            }else if(Objects.nonNull(resultSet)){
                resultSet.close();
            }
        }catch(Exception e){
            e.printStackTrace();
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
    public static void readErrorFile() {
        String line;
        try(BufferedReader bf = new BufferedReader(new FileReader("D:\\outputdepartment_error.txt"))){
            while((line = bf.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
