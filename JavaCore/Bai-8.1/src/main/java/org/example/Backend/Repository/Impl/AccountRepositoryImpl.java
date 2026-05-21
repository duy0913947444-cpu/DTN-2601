package org.example.Backend.Repository.Impl;

import org.example.Backend.Repository.IAccountRepository;
import org.example.Entity.Account;
import org.example.Entity.Department;
import org.example.Entity.Position;
import org.example.Enums.PositionName;
import org.example.Utils.JDBCConnection;
import org.example.Utils.Utils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountRepositoryImpl implements IAccountRepository {
    @Override
    public List<Account> getAccount() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            List<Account> accountList = new ArrayList<>();
            String queryStatement = "SELECT a.*, d.department_name, p.position_name\n" +
                    "FROM `account` a\n" +
                    "left join `department` d on a.department_id = d.department_id\n" +
                    "left join `position` p on a.position_id = p.position_id;";
             connection = JDBCConnection.connectDB("qlcb");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryStatement);
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
        }finally {
            Utils.close(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public boolean updateAccount(String userName, int accountId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String queryStatement = "update `account`\n" +
                    "set user_name = ?\n" +
                    "where account_id = ?;";
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, accountId);
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
    public boolean deleteAccount(int accountID){
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            String disableSafeUpdate = "SET SQL_SAFE_UPDATES = 0;";
            String queryStatement = "DELETE FROM `account`\n" +
                    "WHERE account_id = ?";
            connection = JDBCConnection.connectDB("qlcb");
            statement = connection.createStatement();
            statement.executeUpdate(disableSafeUpdate);
            preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setInt(1, accountID);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, null);
            Utils.close(null, statement, null);
        }
        return false;
    }

    @Override
    public List<Account> findAccountByUserName(String userName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            List<Account> result = new ArrayList<>();
            String queryStatement = "select a.*, d.department_name, p.position_name\n" +
                    "from `account` a\n" +
                    "left join `department` d on a.department_id = d.department_id\n" +
                    "left join `position` p on a.position_id = p.position_id\n" +
                    "where user_name = ?";
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();
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
        }finally {
            Utils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public boolean createAccount(String email, String userName, String fullName, int departmentId, int positionId, LocalDate createDate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String queryStatement = "insert into `account`(email,user_name,full_name,department_id,position_id,create_date)\n" +
                    "value (?,?,?,?,?,?)";
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);
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
        }finally {
            Utils.close(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean checkUnique(String nameCol, String noiDung, Integer ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean check = true;
        try {
            String queryStatement = "";
            if("email".equals(nameCol)){
                queryStatement = "select * \n" +
                                 "from `account`\n" +
                                 "where email = ? and (account_id != ? or ? is null)";
            }else if("userName".equals(nameCol)){
                queryStatement = "select * \n" +
                                 "from `account`\n" +
                                 "where user_name = ? and (account_id != ? or ? is null)";
            }
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);

            preparedStatement.setString(1, noiDung);
            if(Objects.isNull(ID)){
                preparedStatement.setNull(2, Types.INTEGER);
                preparedStatement.setNull(3, Types.INTEGER);
            }else{
                preparedStatement.setInt(2, ID);
                preparedStatement.setInt(3, ID);
            }
            rs = preparedStatement.executeQuery();
            if (rs.next()) check = false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, rs);
        }
        return check;
    }

    @Override
    public boolean checkExistID(int accountID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean check = false;
        try{
            String queryStatement = "Select * from `account` where account_id = ? ";

            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);

            preparedStatement.setInt(1,accountID);

            rs = preparedStatement.executeQuery();
            if(rs.next()) check = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, rs);
        }
        return check;
    }

    @Override
    public boolean createAccounts(List<Account> accounts) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String queryStatement = "insert into `account`(email,user_name,full_name,create_date)\n" +
                    "value (?,?,?,?,)";
            connection = JDBCConnection.connectDB("qlcb");
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(queryStatement);
            for(Account account: accounts){
                preparedStatement.setString(1, account.getEmail());
                preparedStatement.setString(2, account.getUser());
                preparedStatement.setString(3, account.getFullName());
                preparedStatement.setString(4, String.valueOf(LocalDate.now()));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, null);
        }
        return false;
    }
}
