package com.vti.DTO;

import com.vti.Entity.Department;
import com.vti.Entity.Position;
import com.vti.Enum.PositionName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PositionDTO {
    private PositionName name;
    public PositionDTO(Position position) {
        this.name = position.getName();
    }
}
