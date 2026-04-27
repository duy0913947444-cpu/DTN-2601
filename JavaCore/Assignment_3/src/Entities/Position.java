package Entities;

public class Position {
    int positionID;
    PositionName positionName;

    //Constructor

    public Position() {
    }

    public Position(PositionName positionName) {
        positionID++;
        this.positionName = positionName;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Entities.Position{" +
                "PositionID=" + positionID +
                ", Entities.positionName=" + positionName +
                '}';
    }
}
