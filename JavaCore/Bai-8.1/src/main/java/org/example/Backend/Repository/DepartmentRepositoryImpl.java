package org.example.Backend.Repository;

import org.example.Entity.Department;
import org.example.Utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements IDepartmentRepository{
    @Override
    public boolean deleteDepartment(String departmentName) {
        String getIdQuery    = "SELECT department_id FROM `department` WHERE department_name = ? LIMIT 1";
        String deleteAccount = "DELETE FROM `account` WHERE department_id = ?";
        String deleteDepartment = "DELETE FROM `department` WHERE department_id = ?";

        try (Connection conn = JDBCConnection.connectDB("qlcb")) {
            conn.setAutoCommit(false);

            int departmentId;
            try (PreparedStatement ps = conn.prepareStatement(getIdQuery)) {
                ps.setString(1, String.valueOf(departmentName));
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) return false;
                departmentId = rs.getInt("department_id");
            }

            try (PreparedStatement ps = conn.prepareStatement(deleteAccount)) {
                ps.setInt(1, departmentId);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = conn.prepareStatement(deleteDepartment)) {
                ps.setInt(1, departmentId);
                int rows = ps.executeUpdate();
                conn.commit();
                return rows > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDepartment(String departmentName, int departmentId) {
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

    @Override
    public boolean createDepartment(String departmentName) {
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

    @Override
    public List<Department> getDepartment() {
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

    @Override
    public List<Department> getDepartmentWithSmallestAccount() {
        List<Department> departmentList = new ArrayList<>();
        String subQuery = "select count(1)\n" +
                "\t\t\t\t\tfrom `department` d\n" +
                "\t\t\t\t\tjoin `account` a on a.department_id = d.department_id\n" +
                "\t\t\t\t\tgroup by d.department_id\n" +
                "\t\t\t\t\torder by count(1)\n" +
                "\t\t\t\t\tlimit 1";
        String query = "select d.*\n" +
                "from `department` d\n" +
                "join `account` a on a.department_id = d.department_id\n" +
                "group by d.department_id\n" +
                "having count(1) = ?";
        try{
            Connection connection = JDBCConnection.connectDB("qlcb");
            //Subquery
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(subQuery);
            if(!resultSet.next()) return null;
            int count = resultSet.getInt("count(1)");
            //Query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,count);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                departmentList.add(department);
            }
            return departmentList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> getDepartmentWithHighestAccount() {
        List<Department> departmentList = new ArrayList<>();
        String subQuery = "select count(1)\n" +
                "\t\t\t\t\tfrom `department` d\n" +
                "\t\t\t\t\tjoin `account` a on a.department_id = d.department_id\n" +
                "\t\t\t\t\tgroup by d.department_id\n" +
                "\t\t\t\t\torder by count(1) desc\n" +
                "\t\t\t\t\tlimit 1";
        String query = "select d.*\n" +
                "from `department` d\n" +
                "join `account` a on a.department_id = d.department_id\n" +
                "group by d.department_id\n" +
                "having count(1) = ?";
        try{
            Connection connection = JDBCConnection.connectDB("qlcb");
            //Subquery
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(subQuery);
            if(!resultSet.next()) return null;
            int count = resultSet.getInt("count(1)");
            //Query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,count);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                departmentList.add(department);
            }
            return departmentList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> findDepartmentByName(String departmentName) {
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
