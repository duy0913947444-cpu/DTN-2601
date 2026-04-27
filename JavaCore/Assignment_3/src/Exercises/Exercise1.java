package Exercises;

import Entities.Account;

import java.util.Objects;
import java.util.Random;

public class Exercise1 {
    static Random rd = new Random();

    public static void question1(Account account, float salary) {
        if (Objects.isNull(account)) return;
        account.setSalary((int) salary);
    }

    public static int question2() {
        return rd.nextInt(99999);
    }

    public static int question3(int number) {
        return number % 100;
    }

    public static float question4(int a, int b) {
        return (float) a / b;
    }
}
