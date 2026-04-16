import java.time.LocalDate;

public class Group {
    int groupID;
    String groupName;
    Account creator;
    LocalDate createDate;

    //Constructor

    public Group(String groupName, Account creator, LocalDate createDate) {
        this.groupID++;
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
