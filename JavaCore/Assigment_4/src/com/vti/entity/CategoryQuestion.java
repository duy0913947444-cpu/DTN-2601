package com.vti.entity;

public class CategoryQuestion {
    private int categoryID;
    private String categoryName;

    //Constructor

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryQuestion(String categoryName) {
        this.categoryID++;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "com.vti.entity.CategoryQuestion{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
