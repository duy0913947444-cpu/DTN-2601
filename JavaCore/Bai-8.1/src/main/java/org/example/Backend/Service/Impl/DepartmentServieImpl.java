package org.example.Backend.Service.Impl;

import org.example.Backend.Repository.Impl.DepartmentRepositoryImpl;
import org.example.Backend.Repository.IDepartmentRepository;
import org.example.Backend.Service.IDepartmentService;
import org.example.Entity.Department;

import java.util.List;

public class DepartmentServieImpl implements IDepartmentService {
    private IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    @Override
    public boolean deleteDepartment(int departmentID) {
        return departmentRepository.deleteDepartment(departmentID);
    }

    @Override
    public boolean updateDepartment(String departmentName, int departmentId) {
        return departmentRepository.updateDepartment(departmentName,departmentId);
    }

    @Override
    public boolean createDepartment(String departmentName) {
        return departmentRepository.createDepartment(departmentName);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.getDepartment();
    }

    @Override
    public List<Department> getDepartmentWithSmallestAccount() {
        return departmentRepository.getDepartmentWithSmallestAccount();
    }

    @Override
    public List<Department> getDepartmentWithHighestAccount() {
        return departmentRepository.getDepartmentWithHighestAccount();
    }

    @Override
    public List<Department> findDepartmentByName(String departmentName) {
        return departmentRepository.findDepartmentByName(departmentName);
    }

    @Override
    public boolean checkExistName(String departmentName, Integer ID) {
        return departmentRepository.checkExistName(departmentName, ID);
    }

    @Override
    public boolean checkExistID(int departmentID) {
        return departmentRepository.checkExistID(departmentID);
    }
}
