package com.vti.entity;

public class ExamQuestion {
    private Exam exam;
    private Question question;

    //Constructor

    public ExamQuestion(Exam exam, Question question) {
        this.exam = exam;
        this.question = question;
    }

    @Override
    public String toString() {
        return "com.vti.entity.ExamQuestion{" +
                "exam=" + exam +
                ", question=" + question +
                '}';
    }
}
