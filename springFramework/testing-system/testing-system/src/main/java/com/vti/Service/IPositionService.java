package com.vti.Service;

import com.vti.DTO.PositionDTO;
import com.vti.Entity.Position;
import com.vti.From.PositionFrom;
import com.vti.From.PositionSearchFrom;

import java.util.List;

public interface IPositionService {
    List<PositionDTO> findAll(PositionSearchFrom positionSearchFrom);

    void createPosition(PositionFrom position);
}
