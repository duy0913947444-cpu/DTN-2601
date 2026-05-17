package org.example.Backend.Service.Impl;

import org.example.Backend.Repository.IPositionRepository;
import org.example.Backend.Repository.Impl.PositionRepositoryImpl;
import org.example.Backend.Service.IPositionService;
import org.example.Entity.Position;
import org.example.Enums.PositionName;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> getPosition() {
        return positionRepository.getPosition();
    }

    @Override
    public boolean createPosition(PositionName positionName) {
        return positionRepository.createPosition(positionName);
    }

    @Override
    public boolean updatePosition(PositionName positionName, int positionId) {
        return positionRepository.updatePosition(positionName,positionId);
    }

    @Override
    public boolean deletePosition(int positionID) {
        return positionRepository.deletePosition(positionID);
    }

    @Override
    public List<Position> findPositionByName(PositionName positionName) {
        return positionRepository.findPositionByName(positionName);
    }

    @Override
    public List<Position> getPositionWithHighestAccount() {
        return positionRepository.getPositionWithHighestAccount();
    }

    @Override
    public List<Position> getPositionWithSmallestAccount() {
        return positionRepository.getPositionWithSmallestAccount();
    }

    @Override
    public boolean checkExistName(PositionName positionName, Integer ID) {
        return positionRepository.checkExistName(positionName, ID);
    }

    @Override
    public boolean checkExistID(int positionId) {
        return positionRepository.checkExistID(positionId);
    }
}
