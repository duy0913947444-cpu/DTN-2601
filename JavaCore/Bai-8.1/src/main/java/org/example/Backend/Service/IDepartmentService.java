package org.example.Backend.Service;


import org.example.Entity.Department;

import java.util.List;

public interface IDepartmentService {
    boolean deleteDepartment(int departmentID);
    boolean updateDepartment(String departmentName, int departmentId);
    boolean createDepartment(String departmentName);
    List<Department> getDepartment();
    List<Department> getDepartmentWithSmallestAccount();
    List<Department> getDepartmentWithHighestAccount();
    List<Department> findDepartmentByName(String departmentName);

    boolean checkExistName(String departmentName, Integer ID);

    boolean checkExistID(int departmentID);
}
