package Entities;

public class Department {
    int departmentID;
    String departmentName;

    //Constructor

    public Department(String departmentName) {
        this.departmentID++;
        this.departmentName = departmentName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Entities.Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
