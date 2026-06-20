package com.vti.Service;


import com.vti.DTO.DepartmentDTO;
import com.vti.Entity.Department;
import com.vti.From.DepartmentFrom;
import com.vti.From.DepartmentSearchFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<DepartmentDTO> findAll(Pageable pageable , DepartmentSearchFrom departmentSearchFrom);

    DepartmentDTO findByID(Integer id);

    DepartmentDTO findByName(String name);

    void createDepartment(DepartmentFrom department);

    void updateDepartment(DepartmentFrom department, Integer id);

    void deleteById(Integer id);
}
