package org.example.Backend.Repository;

import org.example.Entity.Account;
import org.example.Entity.Department;
import org.example.Entity.Position;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAccountRepository {
    List<Account> getAccount();
    boolean updateAccount(String userName,int accountId);
    boolean deleteAccount(int accountID);
    List<Account> findAccountByUserName(String userName);
    boolean createAccount(String email, String userName, String fullName, int departmentId,
                          int positionId, LocalDate createDate);

    boolean checkUnique(String nameCol, String noidung, Integer ID);

    boolean checkExistID(int accountID);

    boolean createAccounts(List<Account> accounts) throws SQLException;

    void getAccountContext(Set<String> sAccountByUserName, Set<String> sAccountByEmail, List<Integer> departments, List<Integer> positions);
}
