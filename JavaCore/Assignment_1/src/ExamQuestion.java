public class ExamQuestion {
    Exam exam;
    Question question;

    //Constructor

    public ExamQuestion(Exam exam, Question question) {
        this.exam = exam;
        this.question = question;
    }

    @Override
    public String toString() {
        return "ExamQuestion{" +
                "exam=" + exam +
                ", question=" + question +
                '}';
    }
}
