package com.vti.Repository;

import com.vti.Entity.Position;
import com.vti.Enum.PositionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IPositionRepository extends JpaRepository<Position, Integer>, JpaSpecificationExecutor<Position> {
    boolean existsByName(PositionName positionName);
}
