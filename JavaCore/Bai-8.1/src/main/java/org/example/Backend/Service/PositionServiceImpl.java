package org.example.Backend.Service;

import org.example.Backend.Repository.IPositionRepository;
import org.example.Backend.Repository.PositionRepositoryImpl;
import org.example.Entity.Position;
import org.example.Enums.PositionName;

import java.util.List;

public class PositionServiceImpl implements IPositionService{
    @Override
    public List<Position> getPosition() {
        IPositionRepository positionRepository = new PositionRepositoryImpl();
        return positionRepository.getPosition();
    }

    @Override
    public boolean createPosition(PositionName positionName) {
        IPositionRepository positionRepository = new PositionRepositoryImpl();
        return positionRepository.createPosition(positionName);
    }

    @Override
    public boolean updatePosition(PositionName positionName, int positionId) {
        IPositionRepository positionRepository = new PositionRepositoryImpl();
        return positionRepository.updatePosition(positionName,positionId);
    }

    @Override
    public boolean deletePosition(PositionName positionName) {
        IPositionRepository positionRepository = new PositionRepositoryImpl();
        return positionRepository.deletePosition(positionName);
    }

    @Override
    public List<Position> findPositionByName(PositionName positionName) {
        IPositionRepository positionRepository = new PositionRepositoryImpl();
        return positionRepository.findPositionByName(positionName);
    }

    @Override
    public List<Position> getPositionWithHighestAccount() {
        IPositionRepository positionRepository = new PositionRepositoryImpl();
        return positionRepository.getPositionWithHighestAccount();
    }

    @Override
    public List<Position> getPositionWithSmallestAccount() {
        IPositionRepository positionRepository = new PositionRepositoryImpl();
        return positionRepository.getPositionWithSmallestAccount();
    }
}
