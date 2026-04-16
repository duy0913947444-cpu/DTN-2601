import java.time.LocalDate;

public class Account {
    int accountID;
    String email;
    String userName;
    String fullname;
    Department department;
    Position position;
    LocalDate createDate;
    //Constructor

    public Account(String email, String userName, String fullname, Department department, Position position, LocalDate createDate) {
        this.accountID++;
        this.email = email;
        this.userName = userName;
        this.fullname = fullname;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
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
