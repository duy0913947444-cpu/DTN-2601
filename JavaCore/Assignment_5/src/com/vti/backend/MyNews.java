package com.vti.backend;


import com.vti.Entity.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MyNews {
    private Scanner sc = new Scanner(System.in);
    News news;
    public void menu(){
        do{
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("Exit");
            String choose = sc.nextLine();
            switch(choose){
                case "1":
                    news = createNews();
                    break;
                case "2":
                    if(Objects.isNull(news)) break;
                    news.display();
                    break;
                case "3":
                    if(Objects.isNull(news)) break;
                    news.display();
                    break;
                default:
                    return;
            }
        }while(true);
    }
    public News createNews(){
        String title, publishDate, author, content;
        System.out.println("Nhap title: ");
        title = sc.nextLine();
        System.out.println("Nhap publishDate: ");
        publishDate = sc.nextLine();
        System.out.println("Nhap author: ");
        author = sc.nextLine();
        System.out.println("Nhap content: ");
        content = sc.nextLine();
        List<Float> rates = new ArrayList<>();
        System.out.println("Nhap 3 rate: ");
        for (int i = 0; i < 3; i++){
            System.out.println("Rate " + (i+1) + ": ");
            Float tempt = sc.nextFloat();
            rates.add(tempt);
        }
        sc.nextLine();
        News news = new News(title, publishDate, author, content);
        news.calculate(rates);
        return news;
    }
}
