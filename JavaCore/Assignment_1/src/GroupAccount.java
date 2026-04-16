import java.time.LocalDate;

public class GroupAccount {
    Group group;
    Account account;
    LocalDate joinDate;

    //Constructor

    public GroupAccount(Group group, Account account, LocalDate joinDate) {
        this.group = group;
        this.account = account;
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "GroupAccount{" +
                "group=" + group +
                ", account=" + account +
                ", joinDate=" + joinDate +
                '}';
    }
}
