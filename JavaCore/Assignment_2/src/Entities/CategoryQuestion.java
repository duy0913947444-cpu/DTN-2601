package Entities;

public class CategoryQuestion {
    int categoryID;
    String categoryName;

    //Constructor

    public CategoryQuestion(String categoryName) {
        this.categoryID++;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Entities.CategoryQuestion{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
