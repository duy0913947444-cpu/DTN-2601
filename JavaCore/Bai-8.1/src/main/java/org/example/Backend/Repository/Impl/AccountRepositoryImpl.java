package org.example.Backend.Repository.Impl;

import org.example.Backend.Repository.IAccountRepository;
import org.example.Entity.Account;
import org.example.Entity.Department;
import org.example.Entity.Position;
import org.example.Enums.PositionName;
import org.example.Utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements IAccountRepository {
    @Override
    public List<Account> getAccount() {
        try {
            List<Account> accountList = new ArrayList<>();
            String queryStatement = "SELECT a.*, d.department_name, p.position_name\n" +
                    "FROM `account` a\n" +
                    "left join `department` d on a.department_id = d.department_id\n" +
                    "left join `position` p on a.position_id = p.position_id;";
            Connection connection = JDBCConnection.connectDB("qlcb");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryStatement);
            Account account;
            while (resultSet.next()) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateAccount(String userName, int accountId) {
        try {
            String queryStatement = "update `account`\n" +
                    "set user_name = ?\n" +
                    "where account_id = ?;";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, accountId);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAccount(int accountID) {
        try {
            String disableSafeUpdate = "SET SQL_SAFE_UPDATES = 0;";
            String queryStatement = "DELETE FROM `account`\n" +
                    "WHERE account_id = ?";
            Connection connection = JDBCConnection.connectDB("qlcb");
            Statement statement = connection.createStatement();
            statement.executeUpdate(disableSafeUpdate);
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setInt(1, accountID);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Account> findAccountByUserName(String userName) {
        try {
            List<Account> result = new ArrayList<>();
            String queryStatement = "select a.*, d.department_name, p.position_name\n" +
                    "from `account` a\n" +
                    "left join `department` d on a.department_id = d.department_id\n" +
                    "left join `position` p on a.position_id = p.position_id\n" +
                    "where user_name = ?";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Account account;
            while (resultSet.next()) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createAccount(String email, String userName, String fullName, int departmentId, int positionId, LocalDate createDate) {
        try {
            String queryStatement = "insert into `account`(email,user_name,full_name,department_id,position_id,create_date)\n" +
                    "value (?,?,?,?,?,?)";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, fullName);
            preparedStatement.setInt(4, departmentId);
            preparedStatement.setInt(5, positionId);
            preparedStatement.setString(6, String.valueOf(createDate));
            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkUnique(String nameCol, String noiDung) {
        boolean check = true;
        try {
            String queryStatement = "Select * from `account` where 1=1 ";
            if("email".equals(nameCol)){
                queryStatement += " and email = ? ";
            }else if("userName".equals(nameCol)){
                queryStatement += " and user_name = ? ";
            }
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);

            preparedStatement.setString(1, noiDung);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) check = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean checkExistID(int accountID) {
        boolean check = false;
        try{
            String queryStatement = "Select * from `account` where account_id = ? ";

            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);

            preparedStatement.setInt(1,accountID);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) check = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return check;
    }
}
