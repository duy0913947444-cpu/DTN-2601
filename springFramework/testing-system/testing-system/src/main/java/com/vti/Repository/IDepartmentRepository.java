package com.vti.Repository;

import com.vti.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    Optional<Department> findByName(String name);

    boolean existsByName(String departmentName);

    boolean existsByNameAndIdNot(String name, Integer id);
}
