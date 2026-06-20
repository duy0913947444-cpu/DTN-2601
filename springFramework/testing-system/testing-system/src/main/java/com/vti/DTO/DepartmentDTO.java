package com.vti.DTO;

import com.vti.Entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private String name;

    public DepartmentDTO(Department department) {
        this.name = department.getName();
    }
}
