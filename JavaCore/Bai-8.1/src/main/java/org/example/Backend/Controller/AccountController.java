package org.example.Backend.Controller;

import org.example.Backend.Repository.AccountRepositoryImpl;
import org.example.Backend.Repository.IAccountRepository;
import org.example.Backend.Service.AccountServiceImpl;
import org.example.Backend.Service.IAccoountService;
import org.example.Entity.Account;

import java.time.LocalDate;
import java.util.List;

public class AccountController {

    public List<Account> getAccount() {
        IAccoountService accountService = new AccountServiceImpl();
        return accountService.getAccount();
    }

    public boolean updateAccount(String email, String userName, String fullName,
                                 int departmentId, int positionId, int accountId) {
        IAccoountService accountService = new AccountServiceImpl();
        return accountService.updateAccount(email,userName,fullName,departmentId,positionId,accountId);
    }

    public boolean deleteAccount(String userName) {
        IAccoountService accountService = new AccountServiceImpl();
        return accountService.deleteAccount(userName);
    }

    public List<Account> findAccountByUserName(String userName) {
        IAccoountService accountService = new AccountServiceImpl();
        return accountService.findAccountByUserName(userName);
    }

    public boolean createAccount(String email, String userName, String fullName, int departmentId, int positionId, LocalDate createDate) {
        IAccoountService accountService = new AccountServiceImpl();
        return accountService.createAccount(email,userName,fullName,departmentId,positionId,LocalDate.now());
    }
}
