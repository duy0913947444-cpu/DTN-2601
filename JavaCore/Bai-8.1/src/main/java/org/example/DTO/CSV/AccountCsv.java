package org.example.DTO.CSV;

public class AccountCsv {
    private String userName;
    private String fullName;
    private String email;
    private String departmentID;
    private String positionID;

    public AccountCsv(String userName, String fullName, String email,
                      String departmentID, String positionID) {
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.departmentID = departmentID;
        this.positionID = positionID;
    }

    public AccountCsv() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }
}
