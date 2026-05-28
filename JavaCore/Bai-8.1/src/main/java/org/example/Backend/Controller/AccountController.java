package org.example.Backend.Controller;

import org.example.Backend.Service.Impl.AccountServiceImpl;
import org.example.Backend.Service.IAccoountService;
import org.example.Entity.Account;

import java.time.LocalDate;
import java.util.List;

public class AccountController {
    private IAccoountService accountService = new AccountServiceImpl();

    public List<Account> getAccount() {
        return accountService.getAccount();
    }

    public boolean updateAccount(String userName, int accountId) {
        return accountService.updateAccount(userName,accountId);
    }

    public boolean deleteAccount(int accountID) {
        return accountService.deleteAccount(accountID);
    }

    public List<Account> findAccountByUserName(String userName) {
        return accountService.findAccountByUserName(userName);
    }

    public boolean createAccount(String email, String userName, String fullName,
                                 int departmentId, int positionId, LocalDate createDate) {
        return accountService.createAccount(email,userName,fullName,
                departmentId,positionId,LocalDate.now());
    }

    public boolean checkUnique(String nameCol, String noiDung, Integer ID) {
        return accountService.checkUnique(nameCol, noiDung, ID);
    }

    public boolean checkExistID(int accountID) {
        return accountService.checkExistID(accountID);
    }


    public String importAccountToCSV(String path) {
        return accountService.importAccountToCSV(path);
    }
}
