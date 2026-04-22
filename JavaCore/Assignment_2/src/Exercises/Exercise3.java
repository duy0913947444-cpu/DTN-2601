package Exercises;

import Entities.Exam;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Exercise3 {
    public static void question1(Exam exam){
        System.out.println(exam.getExamID());
        System.out.println(exam.getCode());
        System.out.println(exam.getCategoryQuestion());
        System.out.println(exam.getTitle());
        System.out.println(exam.getCreator());
        System.out.println(exam.getDuration());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss",
                new Locale("vi", "VN"));
        String formattedDate = exam.getCreateDate().format(formatter);
        System.out.println("Ngày tạo: " + formattedDate);
    }
    public static void question2(Exam exam){
        System.out.println(exam.getExamID());
        System.out.println(exam.getCode());
        System.out.println(exam.getCategoryQuestion());
        System.out.println(exam.getTitle());
        System.out.println(exam.getCreator());
        System.out.println(exam.getDuration());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss",
                new Locale("vi", "VN"));
        String formattedDate = exam.getCreateDate().format(formatter);
        System.out.println("Ngày tạo: " + formattedDate);
    }
}
