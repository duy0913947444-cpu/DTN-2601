package com.vti.Backend;

import com.vti.Entity.Account;
import com.vti.Entity.Department;
import com.vti.Utils.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountManagement {
    public static List<Account> getAccount() throws SQLException, ClassNotFoundException {
        List<Account> accountList = new ArrayList<>();
        String queryStatement = "select * from account";
        ResultSet resultSet = Connection.connectDB(queryStatement, "qlcb");
        Account account;
        while(resultSet.next()){
            account = new Account();
            account.setAccountId(resultSet.getInt("account_id"));
            account.setEmail(resultSet.getString("email"));
            account.setUser(resultSet.getString("user_name"));
            account.setFullName(resultSet.getString("full_name"));
            account.setDepartmentId(resultSet.getInt("department_id"));
            account.setPositionId(resultSet.getInt("position_id"));
            account.setDate(LocalDate.parse(resultSet.getString("create_date")));
            accountList.add(account);
        }
        return accountList;
    }
}
