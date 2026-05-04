package com.vti.entity;

import Enums.PositionName;

public class Position {
    private int positionID;
    private PositionName positionName;

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
        return "com.vti.entity.Position{" +
                "PositionID=" + positionID +
                ", Entities.positionName=" + positionName +
                '}';
    }
}
