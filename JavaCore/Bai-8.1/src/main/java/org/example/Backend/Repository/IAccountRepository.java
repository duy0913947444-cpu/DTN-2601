package org.example.Backend.Repository;

import org.example.Entity.Account;

import java.time.LocalDate;
import java.util.List;

public interface IAccountRepository {
    List<Account> getAccount();
    boolean updateAccount(String userName,int accountId);
    boolean deleteAccount(int accountID);
    List<Account> findAccountByUserName(String userName);
    boolean createAccount(String email, String userName, String fullName, int departmentId,
                          int positionId, LocalDate createDate);

    boolean checkUnique(String nameCol, String noidung);

    boolean checkExistID(int accountID);
}
