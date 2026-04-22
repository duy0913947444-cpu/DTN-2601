package Entities;

public class Position {
    int PositionID;
    PositionName PositionName;

    //Constructor

    public Position(PositionName positionName) {
        PositionID++;
        PositionName = positionName;
    }

    public int getPositionID() {
        return PositionID;
    }

    public void setPositionID(int positionID) {
        PositionID = positionID;
    }

    public Entities.PositionName getPositionName() {
        return PositionName;
    }

    public void setPositionName(Entities.PositionName positionName) {
        PositionName = positionName;
    }

    @Override
    public String toString() {
        return "Entities.Position{" +
                "PositionID=" + PositionID +
                ", Entities.PositionName=" + PositionName +
                '}';
    }
}
