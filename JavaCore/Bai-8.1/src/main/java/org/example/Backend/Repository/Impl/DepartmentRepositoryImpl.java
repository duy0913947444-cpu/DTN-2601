package org.example.Backend.Repository.Impl;

import org.example.Backend.Repository.IDepartmentRepository;
import org.example.Entity.Department;
import org.example.Utils.JDBCConnection;
import org.example.Utils.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentRepositoryImpl implements IDepartmentRepository {
    @Override
    public boolean deleteDepartment(int departmentID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementAccount = null;
        Statement statement = null;
        String disableSafeUpdate = "SET SQL_SAFE_UPDATES = 0;";
        String deleteAccount = "DELETE FROM `account` WHERE department_id = ?";
        String deleteDepartment = "DELETE FROM `department` WHERE department_id = ?";

        try{
            connection = JDBCConnection.connectDB("qlcb");
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.executeUpdate(disableSafeUpdate);
            //delete account
            preparedStatementAccount = connection.prepareStatement(deleteAccount);
            preparedStatementAccount.setInt(1, departmentID);
            preparedStatementAccount.executeUpdate();
            //delete department
            preparedStatement = connection.prepareStatement(deleteDepartment);
            preparedStatement.setInt(1, departmentID);
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                connection.commit();
                return true;
            }else{
                connection.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, null);
            Utils.close(null, preparedStatementAccount, null);
            Utils.close(null, statement, null);
        }
        return false;
    }

    @Override
    public boolean updateDepartment(String departmentName, int departmentId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String queryStatement = "update `department`\n" +
                    "set department_name = ?\n" +
                    "where department_id = ?";
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, departmentName);
            preparedStatement.setInt(2, departmentId);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean createDepartment(String departmentName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String queryStatement = "insert into `department`(department_name)\n" +
                    "value (?)";
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, departmentName);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public List<Department> getDepartment() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            List<Department> departmentList = new ArrayList<>();
            String queryStatement = "select * from department";
            connection = JDBCConnection.connectDB("qlcb");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryStatement);
            Department department;
            while (resultSet.next()) {
                department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                departmentList.add(department);
            }
            return departmentList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public List<Department> getDepartmentWithSmallestAccount() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet rs = null;
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
        try {
            connection = JDBCConnection.connectDB("qlcb");
            //Subquery
            statement = connection.createStatement();
            resultSet = statement.executeQuery(subQuery);
            if (!resultSet.next()) return null;
            int count = resultSet.getInt("count(1)");
            //Query
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, count);
            rs = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                departmentList.add(department);
            }
            return departmentList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, resultSet);
            Utils.close(null, statement, rs);
        }
        return null;
    }

    @Override
    public List<Department> getDepartmentWithHighestAccount() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet rs = null;
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
        try {
            connection = JDBCConnection.connectDB("qlcb");
            //Subquery
            statement = connection.createStatement();
            resultSet = statement.executeQuery(subQuery);
            if (!resultSet.next()) return null;
            int count = resultSet.getInt("count(1)");
            //Query
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, count);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                departmentList.add(department);
            }
            return departmentList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, resultSet);
            Utils.close(null, statement, rs);
        }
        return null;
    }

    @Override
    public List<Department> findDepartmentByName(String departmentName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            List<Department> result = new ArrayList<>();
            String queryStatement = "select *\n" +
                    "from `department`\n" +
                    "where department_name = ?";
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, departmentName);
            resultSet = preparedStatement.executeQuery();
            Department department;
            while (resultSet.next()) {
                department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                result.add(department);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public boolean checkExistName(String departmentName, Integer ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean check = false;
        try {
            String queryStatement = "select * \n" +
                                    "from department\n" +
                                    "where department_name = ? and (department_id != ? or ? is null)";
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, departmentName);
            if(Objects.isNull(ID)){
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
                preparedStatement.setNull(3, java.sql.Types.INTEGER);
            }else{
                preparedStatement.setInt(2, ID);
                preparedStatement.setInt(3, ID);
            }
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, null);
        }
        return check;
    }
    @Override
    public boolean checkExistID(Integer ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean check = false;
        try{
            String queryStatement = "Select * from department where department_id = ? ";

            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);

            preparedStatement.setInt(1,ID);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) check = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, null);
        }
        return check;
    }

    @Override
    public boolean createDepartments(List<Department> departmentList) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String queryStatement = "insert into `department`(department_name)\n" +
                    "value (?)";
            connection = JDBCConnection.connectDB("qlcb");
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(queryStatement);
            for(Department department : departmentList){
                preparedStatement.setString(1, department.getDepartmentName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
            return true;
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, null);
        }
        return false;
    }

}