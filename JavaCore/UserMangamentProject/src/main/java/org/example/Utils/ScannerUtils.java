package org.example.Utils;

import java.util.Scanner;

import static org.example.Common.StringCommon.emailRegex;
import static org.example.Common.StringCommon.nameRegex;

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
        do{
            email = inputString();
            if(email.matches(emailRegex)){
                return email;
            }else{
                System.out.println("Email ko hop le!");
            }
        }while(true);
    }
    public static String inputPassword(){
        boolean check = false;
        String pass;
        do{
            pass = inputString();
            if(pass.length() >= 6 && pass.length() <= 12){
                for (int i = 0; i < pass.length(); i++) {
                    if(Character.isUpperCase(pass.charAt(i))){
                        return pass;
                    }
                }
            }
            System.out.println("Nhap sai");
        }while(true);
    }

    public static String inputName() {
        String name;
        do{
            name = inputString();
            if(name.matches(nameRegex)){
                return name;
            }
            System.out.println("Nhap sai");
        }while(true);
    }
}
