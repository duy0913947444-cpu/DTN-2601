package org.example.Frontend;

import org.example.Entity.FresherCandidate;
import org.example.Utils.ScannerUtils;

import java.util.Scanner;

public class CandidateFunction {
    private static Scanner sc = new Scanner(System.in);
    public void menu(){
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("other. Exit");
        String choose = sc.nextLine();
        switch(choose){
            case "1":
                register();
                break;
            case "2":
                break;
            default:
        }
    }

    public void register() {
        System.out.println("Nhap firstName:");
        String firstName = ScannerUtils.inputString();
        System.out.println("Nhap lastName:");
        String lastNam = ScannerUtils.inputString();
        System.out.println("Nhap phoneNumber");
        String phone;
        String email;
        String password;
        FresherCandidate fresherCandidate = new FresherCandidate();

    }
}
