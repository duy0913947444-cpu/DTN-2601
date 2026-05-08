package com.vti.Backend;

import com.vti.Entity.Department;
import com.vti.Entity.Position;
import com.vti.Enums.PositionName;
import com.vti.Utils.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentManagement {
    public static List<Department> getDepartment() throws SQLException, ClassNotFoundException {
        List<Department> departmentList = new ArrayList<>();
        String queryStatement = "select * from department";
        ResultSet resultSet = Connection.connectDB(queryStatement, "qlcb");
        Department department;
        while(resultSet.next()){
            department = new Department();
            department.setDepartmentId(resultSet.getInt("department_id"));
            department.setDepartmentName(resultSet.getString("department_name"));
            departmentList.add(department);
        }
        return departmentList;
    }
}
