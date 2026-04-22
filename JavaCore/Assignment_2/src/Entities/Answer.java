package Entities;

public class Answer {
    int answerID;
    String content;
    Question question;
    boolean isCorrect;

    //Constructor

    public Answer(String content, Question question, boolean isCorrect) {
        this.answerID++;
        this.content = content;
        this.question = question;
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "Entities.Answer{" +
                "answerID=" + answerID +
                ", content='" + content + '\'' +
                ", question=" + question +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
