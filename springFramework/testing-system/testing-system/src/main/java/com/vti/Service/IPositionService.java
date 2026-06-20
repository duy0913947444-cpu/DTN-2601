package com.vti.Service;

import com.vti.DTO.PositionDTO;
import com.vti.From.PositionFrom;
import com.vti.From.PositionSearchFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPositionService {
    Page<PositionDTO> findAll(PositionSearchFrom positionSearchFrom, Pageable pageable);

    void createPosition(PositionFrom position);
}
