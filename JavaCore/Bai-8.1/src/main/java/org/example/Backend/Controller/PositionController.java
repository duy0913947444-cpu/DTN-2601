package org.example.Backend.Controller;

import org.example.Backend.Service.IPositionService;
import org.example.Backend.Service.Impl.PositionServiceImpl;
import org.example.Entity.Position;
import org.example.Enums.PositionName;

import java.util.List;

public class PositionController {
    private IPositionService positionService = new PositionServiceImpl();
    public List<Position> getPosition() {
        return positionService.getPosition();
    }

    public boolean createPosition(PositionName positionName) {
        return positionService.createPosition(positionName);
    }

    public boolean updatePosition(PositionName positionName, int positionId) {
        return positionService.updatePosition(positionName,positionId);
    }

    public boolean deletePosition(int positionID) {
        return positionService.deletePosition(positionID);
    }

    public List<Position> findPositionByName(PositionName positionName) {
        return positionService.findPositionByName(positionName);
    }

    public List<Position> getPositionWithHighestAccount() {
        return positionService.getPositionWithHighestAccount();
    }

    public List<Position> getPositionWithSmallestAccount() {
        return positionService.getPositionWithSmallestAccount();
    }

    public boolean checkExistName(PositionName positionName, Integer ID) {
        return positionService.checkExistName(positionName, ID);
    }

    public boolean checkExistID(int positionId) {
        return positionService.checkExistID(positionId);
    }
}
