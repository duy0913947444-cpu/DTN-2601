package org.example.Backend.Repository;

import org.example.Entity.Position;
import org.example.Enums.PositionName;

import java.util.List;

public interface IPositionRepository {
    List<Position> getPosition();
    boolean createPosition(PositionName positionName);
    boolean updatePosition(PositionName positionName, int positionId);
    boolean deletePosition(PositionName positionName);
    List<Position> findPositionByName(PositionName positionName);
    List<Position> getPositionWithHighestAccount();
    List<Position> getPositionWithSmallestAccount();
}
