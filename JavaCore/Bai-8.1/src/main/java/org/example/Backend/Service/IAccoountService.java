package org.example.Backend.Service;

import org.example.Entity.Account;

import java.time.LocalDate;
import java.util.List;

public interface IAccoountService {
    List<Account> getAccount();
    boolean updateAccount(String userName,int accountId);
    boolean deleteAccount(int accountID);
    List<Account> findAccountByUserName(String userName);
    boolean createAccount(String email, String userName, String fullName, int departmentId,
                          int positionId, LocalDate createDate);

    boolean checkUnique(String nameCol, String noiDung, Integer ID);

    boolean checkExistID(int accountID);

    boolean importAccountToCSV(String path);
}
