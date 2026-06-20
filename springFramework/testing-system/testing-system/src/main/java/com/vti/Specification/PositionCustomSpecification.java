package com.vti.Specification;

import com.vti.Entity.Account;
import com.vti.Entity.Position;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class PositionCustomSpecification implements Specification<Position> {
    @NotNull
    private String flied;
    @NotNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<Position> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        if("positionname".equalsIgnoreCase(flied)){
            return criteriaBuilder.like(root.get("name"), "%" + value + "%");
        }
        return null;
    }
}
