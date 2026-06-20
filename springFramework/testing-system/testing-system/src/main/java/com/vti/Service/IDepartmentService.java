package com.vti.Service;


import com.vti.DTO.DepartmentDTO;
import com.vti.Entity.Department;
import com.vti.From.DepartmentFrom;
import com.vti.From.DepartmentSearchFrom;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentDTO> findAll(DepartmentSearchFrom departmentSearchFrom);

    DepartmentDTO findByID(Integer id);

    DepartmentDTO findByName(String name);

    void createDepartment(DepartmentFrom department);

    void updateDepartment(DepartmentFrom department, Integer id);

    void deleteById(Integer id);
}
