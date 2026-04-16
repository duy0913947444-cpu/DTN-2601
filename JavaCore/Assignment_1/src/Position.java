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
        return "Position{" +
                "PositionID=" + PositionID +
                ", PositionName=" + PositionName +
                '}';
    }
}
