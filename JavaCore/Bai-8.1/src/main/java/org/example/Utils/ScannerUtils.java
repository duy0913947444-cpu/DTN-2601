package org.example.Utils;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner sc = new Scanner(System.in);
    public static String inputString(){
        String s;
        do{
            s = sc.nextLine();
            if(!Utils.checkString(s)){
                return s;
            }else{
                System.out.println("Khong hop le!");
            }
        }while(true);
    }
    public static int inputNumber(){
        do{
            try{
                return Integer.parseInt(sc.nextLine().trim());
            }catch (Exception e){
                System.out.println("Nhap lai!");
            }
        }while(true);
    }
    public static int inputID(){
        int ID;
        do{
            ID = inputNumber();
            if(ID < 0){
                System.out.println("Nhap lai ID > 0");
            }else{
                return ID;
            }
        }while(true);
    }
    public static String inputEmail(){
        String email;
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        do{
            email = inputString();
            if(email.matches(emailRegex)){
                return email;
            }else{
                System.out.println("Email ko hop le!");
            }
        }while(true);
    }
}
