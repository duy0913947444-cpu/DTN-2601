package org.example.Entity;

import org.example.Enum.Role;

public class User {
    private int id;
    private String fullName;
    private String Email;
    private String password;
    private String proSkill;
    private int expInYear;
    private Role role;

    public User(int id, String fullName, String email, String password, String proSkill, int expInYear, Role role) {
        this.id = id;
        this.fullName = fullName;
        Email = email;
        this.password = password;
        this.proSkill = proSkill;
        this.expInYear = expInYear;
        this.role = role;
    }

    public User(String fullName, String email, String password, int expInYear, Role role) {
        this.fullName = fullName;
        Email = email;
        this.password = password;
        this.expInYear = expInYear;
        this.role = role;
    }

    public User(String fullName, String email, String password, String proSkill, Role role) {
        this.fullName = fullName;
        Email = email;
        this.password = password;
        this.proSkill = proSkill;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                ", proSkill='" + proSkill + '\'' +
                ", expInYear=" + expInYear +
                ", role=" + role +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User() {
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
