package com.vti.Service;


import com.vti.Entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();

    Department findByID(Integer id);

    Department findByName(String name);

    Department createDepartment(Department department);

    Department updateDepartment(Department department, Integer id);

    void deleteById(Integer id);
}
