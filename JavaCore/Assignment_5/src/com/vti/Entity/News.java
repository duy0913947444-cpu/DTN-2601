package com.vti.Entity;

import java.util.List;

public class News implements INews{
    private int ID;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;


    public News(String title, String publishDate, String author, String content) {
        this.ID++;
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.content = content;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    @Override
    public void display() {
        System.out.println("Title: " + this.getTitle());
        System.out.println("PublishDate: " + this.getPublishDate());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Content: " + this.getContent());
        System.out.println("AverageRate : " + this.getAverageRate());
    }

    @Override
    public void calculate(List<Float> rates) {
        if(rates.isEmpty()) return;
        float result = 0f;
        for(float rate: rates){
            result+= rate;
        }
        this.averageRate =  result/rates.size();
    }
}
