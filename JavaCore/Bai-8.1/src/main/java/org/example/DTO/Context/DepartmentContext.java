package org.example.DTO.Context;

import java.util.Set;

public class DepartmentContext {
    private Set<String> sDepartmentByDepartmentName;

    public DepartmentContext(Set<String> sDepartmentByDepartmentName) {
        this.sDepartmentByDepartmentName = sDepartmentByDepartmentName;
    }

    public Set<String> getsDepartmentByDepartmentName() {
        return sDepartmentByDepartmentName;
    }

    public void setsDepartmentByDepartmentName(Set<String> sDepartmentByDepartmentName) {
        this.sDepartmentByDepartmentName = sDepartmentByDepartmentName;
    }
}
