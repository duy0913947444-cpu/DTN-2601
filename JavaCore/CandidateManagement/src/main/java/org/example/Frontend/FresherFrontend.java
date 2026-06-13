package org.example.Frontend;

import org.example.Backend.Controller.CandidateController;
import org.example.Entity.Fresher;
import org.example.Enum.GraduationRank;
import org.example.Utils.ScannerUtils;
import org.example.Utils.Utils;

import java.util.Scanner;

public class FresherFrontend {
    private CandidateController candidateController = new CandidateController();
    private Scanner sc = new Scanner(System.in);
    public void menu(){
        System.out.println("1.Register");
        System.out.println("2.Login");
        System.out.println("other.Exit");
        String choose = sc.nextLine();
        switch (choose){
            case "1":
                fresherRegister();
                break;
            case "2":
                fresherLogin();
                break;
        }
    }

    private void fresherLogin() {
    }

    private void fresherRegister() {
        System.out.println("Nhap first name:");
        String firstName = ScannerUtils.inputString();
        System.out.println("Nhap last name:");
        String lastName = ScannerUtils.inputString();
        System.out.println("Nhap phone:");
        String phone = ScannerUtils.inputPhone();
        System.out.println("Nhap email:");
        String email = ScannerUtils.inputEmail();
        System.out.println("Nhap password:");
        String password = ScannerUtils.inputPasswors();
        System.out.println("Nhap graduationRank:");
        GraduationRank graduationRank = ScannerUtils.inputGraduationRank();
        Fresher fresher = new Fresher(firstName,lastName,phone,email,password,graduationRank);
        candidateController.addFresher(fresher);
    }
}
