package Exercises;

import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {
    public static Random rd = new Random();
    public static int question1(){
        int number = rd.nextInt();
        return  number;
    }
    public static float question2(){
        float number = rd.nextFloat();
        return  number;
    }
    public static void question3(){
        String[] name = {"Duy", "Nguyen", "Co", "Tuan", "Quan", "Thanh", "Hung"};
        System.out.println(name[rd.nextInt(name.length)]);
    }
    public static void question4(){
        int minDate = (int) LocalDate.of(1995,07,24).toEpochDay();
        int maxDate = (int) LocalDate.of(1995,12,20).toEpochDay();
        int randomDate = minDate + rd.nextInt(maxDate - minDate + 1);
        LocalDate date = LocalDate.ofEpochDay(randomDate);
        System.out.println(date);
    }
    public static void question5(){
        int minDate = (int) LocalDate.now().minusYears(1).toEpochDay();
        int maxDate = (int) LocalDate.now().toEpochDay();
        int randomDate = minDate + rd.nextInt(maxDate - minDate + 1);
        LocalDate date = LocalDate.ofEpochDay(randomDate);
        System.out.println(date);
    }
    public static void question6(){
        LocalDate date = LocalDate.ofEpochDay(rd.nextInt((int) LocalDate.now().toEpochDay() -1));
        System.out.println(date);
    }
    public static void question7(){
        int randomNumber = 100 + rd.nextInt(999-100+1);
        System.out.println(randomNumber);
    }
}
