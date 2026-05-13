package org.example.Frontend;

import org.example.Backend.Controller.AccountController;
import org.example.Backend.Controller.DepartmentController;
import org.example.Entity.Account;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private Scanner sc = new Scanner(System.in);

    private AccountController accountController = new AccountController();
    public void menu(){
        do{
            System.out.println("Nhap chuc nang:");
            System.out.println("1. Show account");
            System.out.println("2. Them account");
            System.out.println("3. Update account");
            System.out.println("4. Xoa account");
            System.out.println("5. Tim account theo ten");
            System.out.println("Other. Exit");
            String choose = sc.nextLine();
            switch (choose){
                case "1":
                    showAccount();
                    break;
                case "2":
                    createAccount();
                    break;
                case "3":
                    updateAccount();
                    break;
                case "4":
                    deleteAccount();
                    break;
                case "5":
                    findByUserName();
                    break;
                default:
                    return;
            }
        }while(true);
    }
    public void showAccount(){
        List<Account> accountList = accountController.getAccount();
        for(Account account: accountList){
            System.out.println(account);
        }
    }
    public void createAccount(){
        System.out.println("Nhap email: ");
        String email = sc.nextLine();
        System.out.println("Nhap userName: ");
        String userName = sc.nextLine();
        System.out.println("Nhap full name: ");
        String fullName = sc.nextLine();
        System.out.println("Nhap department ID: ");
        int departmentId = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap position ID: ");
        int positionId = sc.nextInt();
        sc.nextLine();
        boolean check = accountController.createAccount(email,userName,fullName,departmentId,positionId, LocalDate.now());
        if(check){
            System.out.println("insert success!");
        }else{
            System.out.println("error!");
        }
    }
    public void updateAccount(){
        System.out.println("Nhap ID account can update: ");
        int accountId = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap email: ");
        String email = sc.nextLine();
        System.out.println("Nhap userName: ");
        String userName = sc.nextLine();
        System.out.println("Nhap full name: ");
        String fullName = sc.nextLine();
        System.out.println("Nhap department ID: ");
        int departmentId = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap position ID: ");
        int positionId = sc.nextInt();
        sc.nextLine();
        boolean check = accountController.updateAccount(email,userName,fullName,departmentId,positionId,accountId);
        if(check){
            System.out.println("update success!");
        }else{
            System.out.println("error!");
        }
    }
    public void deleteAccount(){
        System.out.println("Nhap User name can delete: ");
        String userName = sc.nextLine();
        boolean check = accountController.deleteAccount(userName);
        if(check){
            System.out.println("delete success!");
        }else{
            System.out.println("error!");
        }
    }
    public void findByUserName(){
        System.out.println("Nhap userName can tim: ");
        String userName = sc.nextLine();
        List<Account> accountList = accountController.findAccountByUserName(userName);
        if(accountList.isEmpty()){
            System.out.println("Not Found!");
            return;
        }
        for(Account account: accountList){
            System.out.println(account);
        }
    }
}
