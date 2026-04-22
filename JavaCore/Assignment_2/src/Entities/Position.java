package Entities;

public class Position {
    int PositionID;
    PositionName PositionName;

    //Constructor

    public Position(PositionName positionName) {
        PositionID++;
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
