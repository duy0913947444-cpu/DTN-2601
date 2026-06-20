package com.vti.Service.Impl;

import com.vti.DTO.PositionDTO;
import com.vti.Entity.Account;
import com.vti.Entity.Position;
import com.vti.From.PositionFrom;
import com.vti.From.PositionSearchFrom;
import com.vti.Repository.IPositionRepository;
import com.vti.Service.IPositionService;
import com.vti.Specification.AccountCustomSpecification;
import com.vti.Specification.PositionCustomSpecification;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PositionDTO> findAll(PositionSearchFrom positionSearchFrom) {
        Specification<Position> where = Specification.unrestricted(); // where 1=1
        if(StringUtils.isNotEmpty(positionSearchFrom.getPositionName())){
            PositionCustomSpecification positionName = new PositionCustomSpecification(
                    "positionname", positionSearchFrom.getPositionName());
            where = where.and(positionName);
        }
        List<Position> positions = positionRepository.findAll(where);
        List<PositionDTO> positionDTOS = new ArrayList<>();
        for (Position position: positions){
            positionDTOS.add(modelMapper.map(position, PositionDTO.class));
        }
        return positionDTOS;
    }

    @Override
    public void createPosition(PositionFrom positionFrom) {
        if(Objects.isNull(positionFrom.getName())){
            if(positionRepository.existsByName(positionFrom.getName())){
                throw new RuntimeException("Position name was exists!!");
            }
        }
        Position position = new Position();
        position.setName(positionFrom.getName());
        positionRepository.save(position);
    }
}
