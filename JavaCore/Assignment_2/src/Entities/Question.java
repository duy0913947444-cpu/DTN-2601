package Entities;

import java.time.LocalDate;

public class Question {
    int questionID;
    String content;
    CategoryQuestion categoryQuestion;
    TypeQuestion typeQuestion;
    Account creator;
    LocalDate createDate;

    //Constructor

    public Question(String content, CategoryQuestion categoryQuestion, TypeQuestion typeQuestion, Account creator, LocalDate createDate) {
        this.questionID++;
        this.content = content;
        this.categoryQuestion = categoryQuestion;
        this.typeQuestion = typeQuestion;
        this.creator = creator;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Entities.Question{" +
                "questionID=" + questionID +
                ", content='" + content + '\'' +
                ", categoryQuestion=" + categoryQuestion +
                ", typeQuestion=" + typeQuestion +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
