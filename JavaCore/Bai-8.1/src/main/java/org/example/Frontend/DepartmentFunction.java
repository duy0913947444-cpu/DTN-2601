package org.example.Frontend;

import org.example.Backend.Controller.DepartmentController;
import org.example.Entity.Department;
import org.example.Utils.ScannerUtils;
import org.example.Utils.Utils;

import java.util.List;
import java.util.Scanner;

public class DepartmentFunction {
    private Scanner sc = new Scanner(System.in);
    private DepartmentController departmentController = new DepartmentController();
    public void menu(){
        do{
            System.out.println("Nhap chuc nang:");
            System.out.println("1. Show department");
            System.out.println("2. Them department");
            System.out.println("3. Update department");
            System.out.println("4. Xoa department");
            System.out.println("5. Tim department theo ten");
            System.out.println("6. Lay cac department nhiu account nhat");
            System.out.println("7. Lay cac department it account nhat");
            System.out.println("8. import department tu file");
            System.out.println("Other. Exit");
            String choose = sc.nextLine();
            switch (choose){
                case "1":
                    showDepartment();
                    break;
                case "2":
                    createDepartment();
                    break;
                case "3":
                    updateDepartment();
                    break;
                case "4":
                    deleteDepartment();
                    break;
                case "5":
                    findDepartmentByName();
                    break;
                case "6":
                    getDepartmentMaxAccount();
                    break;
                case "7":
                    getDepartmentSmallestAccount();
                    break;
                case "8":
                    importDepartmentToCSV();
                    break;
                default:
                    return;
            }
        }while(true);
    }

    private void importDepartmentToCSV() {
        System.out.println("Nhap path: ");
        String path = ScannerUtils.inputString();
        if(departmentController.importDepartmentToCSV(path)){
            System.out.println("Success!");
        }else{
            Utils.readErrorFile();
        }
    }

    public void showDepartment(){
        List<Department> departmentList = departmentController.getDepartment();
        for(Department department: departmentList){
            System.out.println(department);
        }
    }
    public void createDepartment(){
        String departmentName;
        do{
            System.out.println("Nhap department name:");
            departmentName = ScannerUtils.inputString();
            //Check unique
            if(departmentController.checkExistName(departmentName, null)){
                System.out.println("Name was Exist!");
            }else{
                break;
            }
        }while(true);
        boolean check = departmentController.createDepartment(departmentName);
        if(check){
            System.out.println("insert success!");
        }else{
            System.out.println("error!");
        }
    }
    public void updateDepartment(){
        int departmentId;
        String departmentName;
        do{
            System.out.println("Nhap id department can update:");
            departmentId = ScannerUtils.inputID();
            if(departmentController.checkExistID(departmentId)){
                break;
            }else{
                System.out.println("ID not found!");
            }
        }while(true);
        do {
            System.out.println("Nhap department name:");
            departmentName = ScannerUtils.inputString();
            if(departmentController.checkExistName(departmentName,departmentId)){
                System.out.println("Department name was exist!");
            }else{
                break;
            }
        }while(true);

        boolean check = departmentController.updateDepartment(departmentName,departmentId);
        if(check){
            System.out.println("update success!");
        }else{
            System.out.println("error!");
        }
    }
    public void deleteDepartment(){
        int departmentID;
         do{
            System.out.println("Nhap department id de xoa: ");
            departmentID = ScannerUtils.inputID();
            if(departmentController.checkExistID(departmentID)){
                break;
            }else{
                System.out.println("ID is not found!");
            }
        }while(true);
        boolean check = departmentController.deleteDepartment(departmentID);
        if(check){
            System.out.println("delete success!");
        }else{
            System.out.println("error!");
        }
    }
    public void findDepartmentByName(){
        System.out.println("Nhap department name can tim: ");
        String departmentName = sc.nextLine();
        List<Department> departmentList = departmentController.findDepartmentByName(departmentName);
        if(departmentList.isEmpty()){
            System.out.println("Not Found!");
            return;
        }
        for(Department department: departmentList){
            System.out.println(department);
        }
    }
    public void getDepartmentMaxAccount(){
        List<Department> departmentList = departmentController.getDepartmentWithHighestAccount();
        System.out.println("Department with highest account:");
        for(Department department: departmentList){
            System.out.println(department);
        }
    }
    public void getDepartmentSmallestAccount(){
        List<Department> departmentList = departmentController.getDepartmentWithSmallestAccount();
        System.out.println("Department with smallest account:");
        for(Department department: departmentList){
            System.out.println(department);
        }
    }
}
