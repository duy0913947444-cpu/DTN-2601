package com.vti.Service.Impl;

import com.vti.Entity.Department;
import com.vti.Repository.IDepartmentRepository;
import com.vti.Service.IDepartmentService;
import com.vti.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired //khoi tao doi tuong
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findByID(Integer id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        return departmentOptional.orElse(null);
    }

    @Override
    public Department findByName(String name) {
        return departmentRepository.findByName(name).orElse(null);
    }

    @Override
    public Department createDepartment(Department department) {
        if(departmentRepository.existsByName(department.getName())){
            throw new RuntimeException("Department name was exist!!");
        }
        departmentRepository.save(department);
        return department;
    }

    @Override
    public Department updateDepartment(Department department, Integer id) {
        if(!departmentRepository.existsById(id)){
            throw new RuntimeException("ID is not exist!!");
        }
        if(Objects.nonNull(department.getName())){
            if(Utils.checkString(department.getName())){
                throw new RuntimeException("department name is not null!!");
            }
            if(departmentRepository.existsByNameAndIdNot(department.getName(), id)){
                throw new RuntimeException("Department name was exist!!");
            }
        }
        department.setId(id);
        departmentRepository.save(department);
        return department;
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);
    }
}
