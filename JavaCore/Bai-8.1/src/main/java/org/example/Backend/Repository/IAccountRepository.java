package org.example.Backend.Repository;

import org.example.Entity.Account;

import java.time.LocalDate;
import java.util.List;

public interface IAccountRepository {
    List<Account> getAccount();
    boolean updateAccount(String email, String userName, String fullName, int departmentId,
                                        int positionId, int accountId);
    boolean deleteAccount(String userName);
    List<Account> findAccountByUserName(String userName);
    boolean createAccount(String email, String userName, String fullName, int departmentId,
                          int positionId, LocalDate createDate);
}
