package Exercises;

import Entities.Account;

public class Exercise6 {
    public static void question1(){
        for(int i = 0; i < 10; i+=2)
            System.out.println(i);
    }
    public static void question2(Account[] accounts){
        for(Account account: accounts){
            System.out.println(account);
        }
    }
    public static void question3(){
        for(int i = 0; i < 10; i++)
            System.out.println(i);
    }
}
