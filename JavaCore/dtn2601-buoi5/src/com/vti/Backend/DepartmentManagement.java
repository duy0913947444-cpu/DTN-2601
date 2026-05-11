package com.vti.Backend;

import com.vti.Entity.Account;
import com.vti.Entity.Department;
import com.vti.Entity.Position;
import com.vti.Enums.PositionName;
import com.vti.Utils.JDBCConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DepartmentManagement {
    public static List<Department> getDepartment() {
        try{
            List<Department> departmentList = new ArrayList<>();
            String queryStatement = "select * from department";
            Connection connection = JDBCConnection.connectDB("qlcb");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryStatement);
            Department department;
            while(resultSet.next()){
                department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                departmentList.add(department);
            }
            return departmentList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean createDepartment(String departmentName){
        try{
            String queryStatement = "insert into `department`(department_name)\n" +
                    "value (?)";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,departmentName);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean updateDepartment(String departmentName, int departmentId){
        try{
            String queryStatement = "update `department`\n" +
                    "set department_name = ?\n" +
                    "where department_id = ?";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,departmentName);
            preparedStatement.setInt(2,departmentId);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean deleteDepartment(String departmentName){
        try{
            String disableUpdate = "SET SQL_SAFE_UPDATES = 0;";
            String queryStatement = "DELETE FROM `department`\n" +
                    "WHERE department_name = ?";
            Connection connection = JDBCConnection.connectDB("qlcb");
            Statement statement = connection.createStatement();
            statement.executeUpdate(disableUpdate);
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,departmentName);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static List<Department> findDepartmentByName(String departmentName){
        try{
            List<Department> result = new ArrayList<>();
            String queryStatement = "select *\n" +
                    "from `department`\n" +
                    "where department_name = ?";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,departmentName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Department department;
            while(resultSet.next()){
                department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                result.add(department);
            }
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
