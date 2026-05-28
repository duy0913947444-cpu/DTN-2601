package org.example.Backend.Repository;


import org.example.Entity.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IDepartmentRepository {
    boolean deleteDepartment(int departmentID);
    boolean updateDepartment(String departmentName, int departmentId);
    boolean createDepartment(String departmentName);
    List<Department> getDepartment();
    List<Department> getDepartmentWithSmallestAccount();
    List<Department> getDepartmentWithHighestAccount();
    List<Department> findDepartmentByName(String departmentName);

    boolean checkExistName(String departmentName, Integer ID);
    boolean checkExistID(Integer ID);
    boolean createDepartments(List<Department> departmentList) throws SQLException;

    Set<String> getSetDepartmentName();
}
