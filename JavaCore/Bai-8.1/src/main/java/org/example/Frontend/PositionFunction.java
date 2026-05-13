package org.example.Frontend;


import org.example.Backend.Controller.PositionController;
import org.example.Entity.Position;
import org.example.Enums.PositionName;

import java.util.List;
import java.util.Scanner;

public class PositionFunction {
    private Scanner sc = new Scanner(System.in);
    private PositionController positionController = new PositionController();
    public void menu(){
        do{
            System.out.println("Nhap chuc nang:");
            System.out.println("1. Show position");
            System.out.println("2. Them position");
            System.out.println("3. Update position");
            System.out.println("4. Xoa position");
            System.out.println("5. Tim position theo ten");
            System.out.println("6. Tim position nhieu account nhat");
            System.out.println("7. Tim position it account nhat");
            System.out.println("Other. Exit");
            String choose = sc.nextLine();
            switch (choose){
                case "1":
                    showPosition();
                    break;
                case "2":
                    createPosition();
                    break;
                case "3":
                    updatePosition();
                    break;
                case "4":
                    deletePosition();
                    break;
                case "5":
                    findPositionByName();
                    break;
                case "6":
                    getPositionMaxAccount();
                    break;
                case "7":
                    getPositionSmallestAccount();
                    break;
                default:
                    return;
            }
        }while(true);
    }
    public void showPosition(){
        List<Position> positionList = positionController.getPosition();
        for(Position position: positionList){
            System.out.println(position);
        }
    }
    private PositionName choosePositionName(String choose){
        switch (choose){
            case "1":
                return PositionName.DEV;
            case "2":
                return PositionName.TEST;
            case "3":
                return PositionName.SCRUM_MASTER;
            default:
                return PositionName.PM;
        }
    }
    public void createPosition(){
        System.out.println("Nhap position name:     1.DEV, 2.TEST, 3.SCRUM_MASTER, other.PM");
        String choose = sc.nextLine();
        PositionName positionName = choosePositionName(choose);
        boolean check = positionController.createPosition(positionName);
        if(check){
            System.out.println("insert success!");
        }else{
            System.out.println("error!");
        }
    }
    public void updatePosition(){
        System.out.println("Nhap id position can update:");
        int positionId = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap position name:     1.DEV, 2.TEST, 3.SCRUM_MASTER, other.PM");
        String choose = sc.nextLine();
        PositionName positionName = choosePositionName(choose);
        boolean check = positionController.updatePosition(positionName, positionId);
        if(check){
            System.out.println("update success!");
        }else{
            System.out.println("error!");
        }
    }
    public void deletePosition(){
        System.out.println("Nhap position name de xoa: 1.DEV, 2.TEST, 3.SCRUM_MASTER, other.PM");
        String choose = sc.nextLine();
        PositionName positionName = choosePositionName(choose);
        boolean check = positionController.deletePosition(positionName);
        if(check){
            System.out.println("delete success!");
        }else{
            System.out.println("error!");
        }
    }
    public void findPositionByName(){
        System.out.println("Nhap position name can tim: 1.DEV, 2.TEST, 3.SCRUM_MASTER, other.PM");
        String choose = sc.nextLine();
        PositionName positionName = choosePositionName(choose);
        List<Position> positionList = positionController.findPositionByName(positionName);
        if(positionList.isEmpty()){
            System.out.println("Not Found");
            return;
        }
        for(Position position: positionList){
            System.out.println(position);
        }
    }
    public void getPositionMaxAccount(){
        List<Position> positionList = positionController.getPositionWithHighestAccount();
        System.out.println("Postion with highest account:");
        for(Position position : positionList){
            System.out.println(position);
        }
    }
    public void getPositionSmallestAccount(){
        List<Position> positionList = positionController.getPositionWithHighestAccount();
        System.out.println("Postion with smallest account:");
        for(Position position : positionList){
            System.out.println(position);
        }
    }
}
