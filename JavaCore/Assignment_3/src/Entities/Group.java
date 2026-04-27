package Entities;

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
        return "Entities.Group{" +
                "groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
