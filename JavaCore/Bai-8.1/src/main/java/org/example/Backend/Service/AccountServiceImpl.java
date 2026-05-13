package org.example.Backend.Service;

import org.example.Backend.Repository.AccountRepositoryImpl;
import org.example.Backend.Repository.IAccountRepository;
import org.example.Entity.Account;

import java.time.LocalDate;
import java.util.List;

public class AccountServiceImpl implements IAccoountService{
    @Override
    public List<Account> getAccount() {
        IAccountRepository accountRepository = new AccountRepositoryImpl();
        return accountRepository.getAccount();
    }

    @Override
    public boolean updateAccount(String email, String userName, String fullName,
                                 int departmentId, int positionId, int accountId) {
        IAccountRepository accountRepository = new AccountRepositoryImpl();
        return accountRepository.updateAccount(email,userName,fullName,departmentId,positionId,accountId);
    }

    @Override
    public boolean deleteAccount(String userName) {
        IAccountRepository accountRepository = new AccountRepositoryImpl();
        return accountRepository.deleteAccount(userName);
    }

    @Override
    public List<Account> findAccountByUserName(String userName) {
        IAccountRepository accountRepository = new AccountRepositoryImpl();
        return accountRepository.findAccountByUserName(userName);
    }

    @Override
    public boolean createAccount(String email, String userName, String fullName, int departmentId, int positionId, LocalDate createDate) {
        IAccountRepository accountRepository = new AccountRepositoryImpl();
        return accountRepository.createAccount(email,userName,fullName,departmentId,positionId,LocalDate.now());
    }
}
