package com.vti.backend;


import com.vti.Enums.Gender;
import com.vti.Enums.Level;
import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;
import com.vti.entity.KySu;
import com.vti.entity.NhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class QuanLiCanBo {
    private Scanner sc = new Scanner(System.in);
    private List<CanBo> canBoList = new ArrayList<>();

    public void menu(){
        do{
            System.out.println("1. Add can bo");
            System.out.println("2. Find By Name");
            System.out.println("3. Print List");
            System.out.println("4. Delete Can bo by name");
            System.out.println("Orther exit process");
            String choose = sc.nextLine();
            switch (choose){
                case "1":
                    CanBo addCanBo = addCanBo();
                    if(Objects.isNull(addCanBo)){
                        System.out.println("Error!");
                    }else{
                        canBoList.add(addCanBo);
                    }
                    break;
                case "2":
                    System.out.println("Nhap ten: ");
                    String name = sc.nextLine();
                    CanBo findCanBo = findByName(name);
                    if(Objects.isNull(findCanBo)){
                        System.out.println(name + " not found!");
                    }else{
                        System.out.println(findCanBo);
                    }
                    break;
                case "3":
                    for(CanBo canBo : canBoList){
                        System.out.println(canBo);
                    }
                    break;
                case "4":
                    System.out.println("Nhap ten: ");
                    String nameDelete = sc.nextLine();
                    CanBo findCanBoDelete = findByName(nameDelete);
                    if(Objects.isNull(findCanBoDelete)){
                        System.out.println(nameDelete + " not found!");
                        break;
                    }
                    for(CanBo canBo: canBoList){
                        if(findCanBoDelete.equals(canBo.getName())){
                            canBoList.remove(canBo);
                        }
                    }
                    break;
                default:
                    return;
            }
        }while(true);
    }
    public CanBo addCanBo(){
        CanBo canBo;
        System.out.println("1. Cong nhan    2. Ky su    3. Nhan vien");
        String choose = sc.nextLine();
        System.out.println("name: ");
        String name = sc.nextLine();
        System.out.println("Address: ");
        String address = sc.nextLine();
        System.out.println("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        Gender gender = chooseGender();
        if(choose.equals("1")){
            Level level;
            do{
                level = chooseLevel();
            }while(Objects.isNull(level));
            canBo = new CongNhan(name, age, gender, address, level);
        }else if(choose.equals("2")){
            System.out.println("Nhap nganh dao tao: ");
            String nganhDaoTao = sc.nextLine();
            canBo = new KySu(name, age, gender, address, nganhDaoTao);
        }else if(choose.equals("3")){
            System.out.println("Nhap cong viec: ");
            String position = sc.nextLine();
            canBo = new NhanVien(name, age, gender, address, position);
        }else{
            canBo = null;
        }
        return canBo;
    }
    public Gender chooseGender(){
        Gender gender;
        System.out.println("Gender:     1. Male     2. Female   3.Other");
        String genderChoose = sc.nextLine();
        if("1".equals(genderChoose)){
            gender = Gender.Male;
        }else if("2".equals(genderChoose)){
            gender = Gender.Female;
        }else{
            gender = Gender.Other;
        }
        return gender;
    }
    public Level chooseLevel(){
        Level level;
        System.out.println("Level:     1-10");
        String levelChoose = sc.nextLine();
        switch (levelChoose){
            case "1":
                level = Level.Level1;
                break;
            case "2":
                level = Level.Level2;
                break;
            case "3":
                level = Level.Level3;
                break;
            case "4":
                level = Level.Level4;
                break;
            case "5":
                level = Level.Level5;
                break;
            case "6":
                level = Level.Level6;
                break;
            case "7":
                level = Level.Level7;
                break;
            case "8":
                level = Level.Level8;
                break;
            case "9":
                level = Level.Level9;
                break;
            case "10":
                level = Level.Level10;
                break;
            default:
                level = null;
        }
        return level;
    }
    public CanBo findByName(String name){
        if(Objects.isNull(name)) return null;
        for(CanBo canBo: canBoList){
            if(name.trim().toLowerCase().equals(canBo.getName().trim().toLowerCase())){
                return canBo;
            }
        }
        return null;
    }
}
