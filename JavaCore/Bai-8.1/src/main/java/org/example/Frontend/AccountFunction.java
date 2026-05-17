package org.example.Frontend;

import org.example.Backend.Controller.AccountController;
import org.example.Backend.Controller.DepartmentController;
import org.example.Backend.Controller.PositionController;
import org.example.Entity.Account;
import org.example.Utils.Utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private Scanner sc = new Scanner(System.in);

    private AccountController accountController = new AccountController();
    private DepartmentController departmentController = new DepartmentController();
    private PositionController positionController = new PositionController();
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
        String email, userName, fullName;
        int departmentId, positionId;
        do{
            System.out.println("Nhap email: ");
            email = sc.nextLine();
            if(Utils.checkEmail(email)){
                if(accountController.checkUnique("email", email)){
                    System.out.println("Success!");
                    break;
                }else{
                    System.out.println("Email was exist!");
                }
            }else{
                System.out.println("Email khong hop le!");
            }
        }while(true);
        do{
            System.out.println("Nhap userName: ");
            userName = sc.nextLine();
            if(!Utils.checkString(userName)){
                if(accountController.checkUnique("userName",userName)){
                    System.out.println("Success!");
                    break;
                }else{
                    System.out.println("User name was exist!");
                }
            }else{
                System.out.println("User name khong hop le!");
            }
        }while(true);
        do{
            System.out.println("Nhap full name: ");
            fullName = sc.nextLine();
            if(!Utils.checkString(fullName)){
                break;
            }else{
                System.out.println("Ful name is not empty!");
            }
        }while(true);
        do{
            System.out.println("Nhap department ID: ");
            departmentId = sc.nextInt();
            sc.nextLine();
            if(departmentController.checkExistID(departmentId)){
                break;
            }else{
                System.out.println("Department id was not exist!");
            }
        }while(true);
        do{
            System.out.println("Nhap position ID: ");
            positionId = sc.nextInt();
            sc.nextLine();
            if(positionController.checkExistID(positionId)){
                break;
            }else{
                System.out.println("Position id was not exist!");
            }
        }while(true);
        boolean check = accountController.createAccount(email,userName,fullName,departmentId,positionId, LocalDate.now());
        if(check){
            System.out.println("insert success!");
        }else{
            System.out.println("error!");
        }
    }
    public void updateAccount(){
        int accountID;
        String userName;
        do{
            System.out.println("Nhap ID account can update: ");
            accountID = sc.nextInt();
            sc.nextLine();
            if(accountController.checkExistID(accountID)){
                break;
            }else{
                System.out.println("ID was not exist!");
            }
        }while(true);
        do{
            System.out.println("Nhap userName: ");
            userName = sc.nextLine();
            if(!Utils.checkString(userName)){
                if(accountController.checkUnique("userName",userName)){
                    System.out.println("Success!");
                    break;
                }else{
                    System.out.println("User name was exist!");
                }
            }else{
                System.out.println("User name khong hop le!");
            }
        }while(true);
        boolean check = accountController.updateAccount(userName,accountID);
        if(check){
            System.out.println("update success!");
        }else{
            System.out.println("error!");
        }
    }
    public void deleteAccount(){
        int accountID;
        do{
            System.out.println("Nhap ID account can delete: ");
            accountID = sc.nextInt();
            sc.nextLine();
            if(accountController.checkExistID(accountID)){
                break;
            }else{
                System.out.println("ID was not exist!");
            }
        }while(true);
        boolean check = accountController.deleteAccount(accountID);
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
