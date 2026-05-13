package org.example.Backend.Service;

import org.example.Backend.Repository.DepartmentRepositoryImpl;
import org.example.Backend.Repository.IDepartmentRepository;
import org.example.Entity.Department;

import java.util.List;

public class DepartmentServieImpl implements IDepartmentService{

    @Override
    public boolean deleteDepartment(String departmentName) {
        IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
        return departmentRepository.deleteDepartment(departmentName);
    }

    @Override
    public boolean updateDepartment(String departmentName, int departmentId) {
        IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
        return departmentRepository.updateDepartment(departmentName,departmentId);
    }

    @Override
    public boolean createDepartment(String departmentName) {
        IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
        return departmentRepository.createDepartment(departmentName);
    }

    @Override
    public List<Department> getDepartment() {
        IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
        return departmentRepository.getDepartment();
    }

    @Override
    public List<Department> getDepartmentWithSmallestAccount() {
        IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
        return departmentRepository.getDepartmentWithSmallestAccount();
    }

    @Override
    public List<Department> getDepartmentWithHighestAccount() {
        IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
        return departmentRepository.getDepartmentWithHighestAccount();
    }

    @Override
    public List<Department> findDepartmentByName(String departmentName) {
        IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
        return departmentRepository.findDepartmentByName(departmentName);
    }
}
