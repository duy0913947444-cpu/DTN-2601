package com.vti.Specification;

import com.vti.Entity.Department;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class DepartmentCustomSpecification implements Specification<Department> {
    @NotNull
    private String flied;
    @NotNull
    private Object value;
    @Override
    public Predicate toPredicate(Root<Department> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        if("name".equalsIgnoreCase(flied)){
            return criteriaBuilder.like(root.get("name"), "%" + value + "%");
        }
        return null;
    }
}
