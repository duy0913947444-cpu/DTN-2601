package com.vti.entity;

public class Account1 {
    private String id;
    private String name;
    private int balance;

    //Constructor

    public Account1(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    //Getter

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void credit(int amount){
        this.balance += amount;
    }
    public void debit(int amount){
        this.balance -= amount;
    }
    public void tranferTo(Account1 account, int amount){
        if(this.balance - amount >= 0){
            debit(amount);
            account.credit(amount);
        }
    }
}
