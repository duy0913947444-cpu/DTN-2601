package org.example.Backend.Controller;

import org.example.Backend.Service.Impl.DepartmentServieImpl;
import org.example.Backend.Service.IDepartmentService;
import org.example.Entity.Department;

import java.util.List;

public class DepartmentController {
    private IDepartmentService departmentService = new DepartmentServieImpl();

    public boolean deleteDepartment(int departmentID) {
        return departmentService.deleteDepartment(departmentID);
    }


    public boolean updateDepartment(String departmentName, int departmentId) {
        return departmentService.updateDepartment(departmentName,departmentId);
    }

    public boolean createDepartment(String departmentName) {
        return departmentService.createDepartment(departmentName);
    }

    public List<Department> getDepartment() {
        return departmentService.getDepartment();
    }

    public List<Department> getDepartmentWithSmallestAccount() {
        return departmentService.getDepartmentWithSmallestAccount();
    }

    public List<Department> getDepartmentWithHighestAccount() {
        return departmentService.getDepartmentWithHighestAccount();
    }

    public List<Department> findDepartmentByName(String departmentName) {
        return departmentService.findDepartmentByName(departmentName);
    }

    public boolean checkExistName(String departmentName, Integer ID) {
        return departmentService.checkExistName(departmentName, ID);
    }

    public boolean checkExistID(int departmentID) {
        return departmentService.checkExistID(departmentID);
    }
}
