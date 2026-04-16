import java.time.LocalDate;

public class Exam {
    int examID;
    String code;
    String title;
    CategoryQuestion categoryQuestion;
    int duration;
    Account creator;
    LocalDate createDate;

    //Constructor

    public Exam(String code, String title, CategoryQuestion categoryQuestion, int duration, Account creator, LocalDate createDate) {
        this.examID++;
        this.code = code;
        this.title = title;
        this.categoryQuestion = categoryQuestion;
        this.duration = duration;
        this.creator = creator;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examID=" + examID +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", categoryQuestion=" + categoryQuestion +
                ", duration=" + duration +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
