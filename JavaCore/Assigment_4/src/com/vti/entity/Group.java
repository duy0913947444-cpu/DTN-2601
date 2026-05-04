package com.vti.entity;

import java.time.LocalDate;

public class Group {
    private int groupID;
    private String groupName;
    private Account creator;
    private LocalDate createDate;
    private Account[] accounts;

    //Constructor

    public Group(String groupName, Account creator, LocalDate createDate) {
        this.groupID++;
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
    }

    public Group() {
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Group(int groupID, String groupName, Account creator, LocalDate createDate, Account[] accounts) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
        this.accounts = accounts;
    }
    public Group(int groupID, String groupName, Account creator, LocalDate createDate, String[] users) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
        Account[] accounts = new Account[users.length];
        int i = 0;
        for(String user : users){
            accounts[i++] = new Account(user);
        }
        this.accounts = accounts;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "com.vti.entity.Group{" +
                "groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
