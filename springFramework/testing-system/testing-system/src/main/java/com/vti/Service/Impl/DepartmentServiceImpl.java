package com.vti.Service.Impl;

import com.vti.DTO.DepartmentDTO;
import com.vti.Entity.Department;
import com.vti.From.DepartmentFrom;
import com.vti.From.DepartmentSearchFrom;
import com.vti.Repository.IDepartmentRepository;
import com.vti.Service.IDepartmentService;
import com.vti.Specification.DepartmentCustomSpecification;
import com.vti.Utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired //khoi tao doi tuong
    private IDepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDTO> findAll(DepartmentSearchFrom departmentSearchFrom) {
        Specification<Department> where = Specification.unrestricted(); // where 1=1
        if(StringUtils.isNotEmpty(departmentSearchFrom.getName())){
            DepartmentCustomSpecification name = new DepartmentCustomSpecification(
                    "name", departmentSearchFrom.getName());
            where = where.and(name);
        }
        List<Department> departments = departmentRepository.findAll(where);
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        for (Department department: departments){
            departmentDTOS.add(modelMapper.map(department,DepartmentDTO.class));
        }
        return departmentDTOS;
    }

    @Override
    public DepartmentDTO findByID(Integer id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return modelMapper.map(department,DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO findByName(String name) {
        Department department = departmentRepository.findByName(name).orElse(null);
        return modelMapper.map(department,DepartmentDTO.class);
    }

    @Override
    public void createDepartment(DepartmentFrom departmentFrom) {
        if(departmentRepository.existsByName(departmentFrom.getName())){
            throw new RuntimeException("Department name was exist!!");
        }
        Department department = new Department();
        department.setName(departmentFrom.getName());
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(DepartmentFrom departmentFrom, Integer id) {
        if(!departmentRepository.existsById(id)){
            throw new RuntimeException("ID is not exist!!");
        }
        if(Objects.nonNull(departmentFrom.getName())){
            if(Utils.checkString(departmentFrom.getName())){
                throw new RuntimeException("department name is not null!!");
            }
            if(departmentRepository.existsByNameAndIdNot(departmentFrom.getName(), id)){
                throw new RuntimeException("Department name was exist!!");
            }
        }
        Department department = new Department();
        department.setName(departmentFrom.getName());
        department.setId(id);
        departmentRepository.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);
    }
}
