package org.example.Backend.Controller;

import org.example.Backend.Repository.IPositionRepository;
import org.example.Backend.Repository.PositionRepositoryImpl;
import org.example.Backend.Service.IPositionService;
import org.example.Backend.Service.PositionServiceImpl;
import org.example.Entity.Position;
import org.example.Enums.PositionName;

import java.util.List;

public class PositionController {

    public List<Position> getPosition() {
        IPositionService positionService = new PositionServiceImpl();
        return positionService.getPosition();
    }

    public boolean createPosition(PositionName positionName) {
        IPositionService positionService = new PositionServiceImpl();
        return positionService.createPosition(positionName);
    }

    public boolean updatePosition(PositionName positionName, int positionId) {
        IPositionService positionService = new PositionServiceImpl();
        return positionService.updatePosition(positionName,positionId);
    }

    public boolean deletePosition(PositionName positionName) {
        IPositionService positionService = new PositionServiceImpl();
        return positionService.deletePosition(positionName);
    }

    public List<Position> findPositionByName(PositionName positionName) {
        IPositionService positionService = new PositionServiceImpl();
        return positionService.findPositionByName(positionName);
    }

    public List<Position> getPositionWithHighestAccount() {
        IPositionService positionService = new PositionServiceImpl();
        return positionService.getPositionWithHighestAccount();
    }

    public List<Position> getPositionWithSmallestAccount() {
        IPositionService positionService = new PositionServiceImpl();
        return positionService.getPositionWithSmallestAccount();
    }
}
