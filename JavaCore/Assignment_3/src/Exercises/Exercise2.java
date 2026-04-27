package Exercises;

import Entities.Account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    public static List<Account> question1(){
        List<Account> accountList = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Account account = new Account();
            account.setUserName("User name " + (i+1));
            account.setEmail("Email " + (i+1));
            account.setFullname("Full name " + (i+1));
            account.setCreateDate(LocalDate.now());
            accountList.add(account);
        }
        return accountList;
    }
}
