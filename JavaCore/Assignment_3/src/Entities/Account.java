package Entities;

import java.time.LocalDate;

public class Account {
    private int accountID;
    private String email;
    private String userName;
    private String fullname;
    private Department department;
    private Position position;
    private LocalDate createDate;
    private int salary;
    //Constructor

    public Account(String mail, String user1, String nguyenVanA, Department department, Position position, LocalDate now) {
    }

    public Account(int accountID, String email, String userName, String fullname, Department department, Position position, LocalDate createDate, int salary) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.fullname = fullname;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
        this.salary = salary;
    }

    public Account() {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.fullname = fullname;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Entities.Account{" +
                "accountID=" + accountID +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", fullname='" + fullname + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", createDate=" + createDate +
                '}';
    }

}
