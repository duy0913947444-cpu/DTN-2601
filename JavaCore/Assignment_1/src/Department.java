public class Department {
    int departmentID;
    String departmentName;

    //Constructor

    public Department(String departmentName) {
        this.departmentID++;
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
