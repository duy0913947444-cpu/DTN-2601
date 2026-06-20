package com.vti.Specification;

import com.vti.Entity.Account;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class AccountCustomSpecification implements Specification<Account> {
    @NotNull
    private String flied;
    @NotNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<Account> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        if("username".equalsIgnoreCase(flied)){
            return criteriaBuilder.like(root.get("userName"), "%" + value + "%");
        }
        if("fullname".equalsIgnoreCase(flied)){
            return criteriaBuilder.like(root.get("fullName"), "%" + value + "%");
        }
        if("email".equalsIgnoreCase(flied)){
            return criteriaBuilder.like(root.get("email"), "%" + value + "%");
        }
        if("departmentName".equalsIgnoreCase(flied)){
            return criteriaBuilder.like(root.get("department").get("name"), "%" + value + "%");
        }
        if("positionname".equalsIgnoreCase(flied)){
            return criteriaBuilder.like(root.get("position").get("name"), "%" + value + "%");
        }
        return null;
    }
}
