package org.example.Backend.Controller;

import org.example.Backend.Service.DepartmentServieImpl;
import org.example.Backend.Service.IDepartmentService;
import org.example.Entity.Department;

import java.util.List;

public class DepartmentController {

    public boolean deleteDepartment(String departmentName) {
        IDepartmentService departmentService = new DepartmentServieImpl();
        return departmentService.deleteDepartment(departmentName);
    }


    public boolean updateDepartment(String departmentName, int departmentId) {
        IDepartmentService departmentService = new DepartmentServieImpl();
        return departmentService.updateDepartment(departmentName,departmentId);
    }

    public boolean createDepartment(String departmentName) {
        IDepartmentService departmentService = new DepartmentServieImpl();
        return departmentService.createDepartment(departmentName);
    }

    public List<Department> getDepartment() {
        IDepartmentService departmentService = new DepartmentServieImpl();
        return departmentService.getDepartment();
    }

    public List<Department> getDepartmentWithSmallestAccount() {
        IDepartmentService departmentService = new DepartmentServieImpl();
        return departmentService.getDepartmentWithSmallestAccount();
    }

    public List<Department> getDepartmentWithHighestAccount() {
        IDepartmentService departmentService = new DepartmentServieImpl();
        return departmentService.getDepartmentWithHighestAccount();
    }

    public List<Department> findDepartmentByName(String departmentName) {
        IDepartmentService departmentService = new DepartmentServieImpl();
        return departmentService.findDepartmentByName(departmentName);
    }
}
