import Entities.*;
import Exercises.Exercise1;
import Exercises.Exercise2;
import Exercises.Exercise3;
import Exercises.Exercise4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Department[] departments = new Department[3];
        departments[0] = new Department("Sale");
        departments[1] = new Department("Marketing");
        departments[2] = new Department("Sale");
        Position[] positions = new Position[3];
        positions[0] = new Position(PositionName.SCRUM_MASTER);
        positions[1] = new Position(PositionName.DEV);
        positions[2] = new Position(PositionName.PM);
        Account[] accounts = new Account[3];
        accounts[0] = new Account("user1@gmail.com", "user1", "Nguyen van A", departments[0], positions[0], LocalDate.now());
        accounts[1] = new Account("user2@gmail.com", "user2", "Nguyen van B", departments[1], positions[1], LocalDate.now());
        accounts[2] = new Account("user3@gmail.com", "user3", "Nguyen van C", departments[2], positions[2], LocalDate.now());
        Group[] groups = new Group[4];
        groups[0] = new Group("group1", accounts[0], LocalDate.now());
        groups[1] = new Group("group2", accounts[1], LocalDate.now());
        groups[2] = new Group("group3", accounts[2], LocalDate.now());
        groups[3] = new Group("JavaBackend", accounts[2], LocalDate.now());
        GroupAccount[] groupAccounts = new GroupAccount[3];
        groupAccounts[0] = new GroupAccount(groups[0], accounts[0], LocalDate.now());
        groupAccounts[1] = new GroupAccount(groups[1], accounts[1], LocalDate.now());
        groupAccounts[2] = new GroupAccount(groups[2], accounts[2], LocalDate.now());
        TypeQuestion[] typeQuestions = new TypeQuestion[3];
        typeQuestions[0] = new TypeQuestion(TypeName.ESSAY);
        typeQuestions[1] = new TypeQuestion(TypeName.ESSAY);
        typeQuestions[2] = new TypeQuestion(TypeName.MULTIPLE_CHOICE);
        CategoryQuestion[] categoryQuestions = new CategoryQuestion[3];
        categoryQuestions[0] = new CategoryQuestion("Java");
        categoryQuestions[1] = new CategoryQuestion("SQL");
        categoryQuestions[2] = new CategoryQuestion("Postman");
        Question[] questions = new Question[3];
        questions[0] = new Question("content1", categoryQuestions[0], typeQuestions[0], accounts[0], LocalDate.now());
        questions[1] = new Question("content2", categoryQuestions[1], typeQuestions[1], accounts[1], LocalDate.now());
        questions[2] = new Question("content3", categoryQuestions[2], typeQuestions[2], accounts[2], LocalDate.now());
        Answer[] answers = new Answer[3];
        answers[0] = new Answer("answer1", questions[0], true);
        answers[1] = new Answer("answer2", questions[1], true);
        answers[2] = new Answer("answer3", questions[2], false);
        Exam[] exams = new Exam[3];
        exams[0] = new Exam("code1", "title1", categoryQuestions[0], 30, accounts[0], LocalDateTime.now());
        exams[1] = new Exam("code2", "title2", categoryQuestions[1], 45, accounts[1], LocalDateTime.now());
        exams[2] = new Exam("code3", "title3", categoryQuestions[2], 60, accounts[2], LocalDateTime.now());
        ExamQuestion[] examQuestions = new ExamQuestion[3];
        examQuestions[0] = new ExamQuestion(exams[0], questions[0]);
        examQuestions[1] = new ExamQuestion(exams[1], questions[1]);
        examQuestions[2] = new ExamQuestion(exams[2], questions[2]);
        //Excercise 1
        Exercise1.question1(accounts[0],5240.5f);
        System.out.printf("salary Account 1: %d$\n", accounts[0].getSalary());
        Exercise1.question1(accounts[1],10970.055f);
        System.out.printf("salary Account 2: %d$\n", accounts[1].getSalary());
        int number = Exercise1.question2();
        System.out.printf("Radom 5 chu so: %05d\n", number);
        System.out.printf("%02d\n",Exercise1.question3(number));
        System.out.println(Exercise1.question4(3,6));
        List<Account> accountList = new ArrayList<>(Exercise2.question1());
        for(Account account: accountList){
            System.out.println(account);
        }
        Exercise3.question1();
        System.out.println(Exercise3.question2());
        System.out.println(Exercise3.question3());
        Scanner sc = new Scanner(System.in);
        String s1;
        System.out.println("Nhap s:");
        s1 = sc.nextLine();
        System.out.println(Exercise4.question1(s1));
        String s2,s3;
        System.out.println("Nhap s2,s3: ");
        s2 = sc.nextLine();
        s3 = sc.nextLine();
        System.out.println(Exercise4.question2(s2,s3));
        System.out.println("Nhap ho ten: ");
        String name = sc.nextLine();
        System.out.println(Exercise4.question3(name));
        System.out.println("Question 4, nhap ten: ");
        String name1 = sc.nextLine();
        Exercise4.question4(name1);
        Exercise4.question5();
        Exercise4.question6(name1);
        Exercise4.question8(List.of(groups));
        System.out.println(Exercise4.question10("ok","KO"));
        System.out.println(Exercise4.question11("nguyen van a"));
        Exercise4.question12("nguyen van a");
        System.out.println();
        System.out.println(Exercise4.question14("VTI Academy",'e','*'));
        Exercise4.question15("nguyen van a");
        System.out.println();
        List<String> subString = Exercise4.question16("nguyen van a",4);
        if(Objects.isNull(subString)){
            System.out.println("KO");
        }else{
            for(String s: subString){
                System.out.println(s);
            }
        }
    }
}