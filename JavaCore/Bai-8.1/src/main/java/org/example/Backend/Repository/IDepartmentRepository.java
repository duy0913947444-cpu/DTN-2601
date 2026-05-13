package org.example.Backend.Repository;


import org.example.Entity.Department;

import java.util.List;

public interface IDepartmentRepository {
    boolean deleteDepartment(String departmentName);
    boolean updateDepartment(String departmentName, int departmentId);
    boolean createDepartment(String departmentName);
    List<Department> getDepartment();
    List<Department> getDepartmentWithSmallestAccount();
    List<Department> getDepartmentWithHighestAccount();
    List<Department> findDepartmentByName(String departmentName);
}
