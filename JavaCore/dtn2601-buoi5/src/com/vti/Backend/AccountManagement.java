package com.vti.Backend;

import com.mysql.cj.jdbc.CallableStatement;
import com.vti.Entity.Account;
import com.vti.Entity.Department;
import com.vti.Entity.Position;
import com.vti.Enums.PositionName;
import com.vti.Utils.JDBCConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountManagement {
    public static List<Account> getAccount(){
        try{
            List<Account> accountList = new ArrayList<>();
            String queryStatement = "SELECT a.*, d.department_name, p.position_name\n" +
                    "FROM `account` a\n" +
                    "left join `department` d on a.department_id = d.department_id\n" +
                    "left join `position` p on a.position_id = p.position_id;";
            Connection connection = JDBCConnection.connectDB("qlcb");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryStatement);
            Account account;
            while(resultSet.next()){
                account = new Account();
                account.setAccountId(resultSet.getInt("account_id"));
                account.setEmail(resultSet.getString("email"));
                account.setUser(resultSet.getString("user_name"));
                account.setFullName(resultSet.getString("full_name"));
                Department department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                account.setDepartment(department);
                Position position = new Position();
                position.setPositionId(resultSet.getInt("position_id"));
                position.setPositionName(PositionName.valueOf(resultSet.getString("position_name")));
                account.setPosition(position);
                account.setDate(LocalDate.parse(resultSet.getString("create_date")));
                accountList.add(account);
            }
            return accountList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    // create read update delete
    public static boolean createAccount(String email, String userName, String fullName, int departmentId,
                                        int positionId, LocalDate createDate){
        try{
            String queryStatement = "insert into `account`(email,user_name,full_name,department_id,position_id,create_date)\n" +
                    "value (?,?,?,?,?,?)";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,userName);
            preparedStatement.setString(3,fullName);
            preparedStatement.setInt(4,departmentId);
            preparedStatement.setInt(5,positionId);
            preparedStatement.setString(6,String.valueOf(createDate));
            int c = preparedStatement.executeUpdate();
            return c > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean updateAccount(String email, String userName, String fullName, int departmentId,
                                        int positionId, int accountId){
        try{
            String queryStatement = "update `account`\n" +
                    "set email = ?\n" +
                    ",user_name = ?,\n" +
                    "full_name = ?,\n" +
                    "department_id = ?,\n" +
                    "position_id = ?\n" +
                    "where account_id = ?";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,userName);
            preparedStatement.setString(3,fullName);
            preparedStatement.setInt(4,departmentId);
            preparedStatement.setInt(5,positionId);
            preparedStatement.setInt(6,accountId);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean deleteAccount(String userName){
        try{
            String disableSafeUpdate = "SET SQL_SAFE_UPDATES = 0;";
            String queryStatement = "DELETE FROM `account`\n" +
                    "WHERE user_name = ?";
            Connection connection = JDBCConnection.connectDB("qlcb");
            Statement statement = connection.createStatement();
            statement.executeUpdate(disableSafeUpdate);
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,userName);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static List<Account> findAccountByUserName(String userName){
        try{
            List<Account> result = new ArrayList<>();
            String queryStatement = "select a.*, d.department_name, p.position_name\n" +
                    "from `account` a\n" +
                    "left join `department` d on a.department_id = d.department_id\n" +
                    "left join `position` p on a.position_id = p.position_id\n" +
                    "where user_name = ?";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Account account;
            while(resultSet.next()){
                account = new Account();
                account.setAccountId(resultSet.getInt("account_id"));
                account.setEmail(resultSet.getString("email"));
                account.setUser(resultSet.getString("user_name"));
                account.setFullName(resultSet.getString("full_name"));
                Department department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                account.setDepartment(department);
                Position position = new Position();
                position.setPositionId(resultSet.getInt("position_id"));
                position.setPositionName(PositionName.valueOf(resultSet.getString("position_name")));
                account.setPosition(position);
                account.setDate(LocalDate.parse(resultSet.getString("create_date")));
                result.add(account);
            }
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
