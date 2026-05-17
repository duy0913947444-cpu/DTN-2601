package org.example.Backend.Service.Impl;

import org.example.Backend.Repository.Impl.AccountRepositoryImpl;
import org.example.Backend.Repository.IAccountRepository;
import org.example.Backend.Service.IAccoountService;
import org.example.Entity.Account;

import java.time.LocalDate;
import java.util.List;

public class AccountServiceImpl implements IAccoountService {
    private IAccountRepository accountRepository = new AccountRepositoryImpl();
    @Override
    public List<Account> getAccount() {
        return accountRepository.getAccount();
    }

    @Override
    public boolean updateAccount(String userName, int accountId) {
        return accountRepository.updateAccount(userName,accountId);
    }

    @Override
    public boolean deleteAccount(int accountID) {
        return accountRepository.deleteAccount(accountID);
    }

    @Override
    public List<Account> findAccountByUserName(String userName) {
        return accountRepository.findAccountByUserName(userName);
    }

    @Override
    public boolean createAccount(String email, String userName, String fullName, int departmentId, int positionId, LocalDate createDate) {
        return accountRepository.createAccount(email,userName,fullName,departmentId,positionId,LocalDate.now());
    }

    @Override
    public boolean checkUnique(String nameCol, String noiDung) {
        return accountRepository.checkUnique(nameCol,noiDung);
    }

    @Override
    public boolean checkExistID(int accountID) {
        return accountRepository.checkExistID(accountID);
    }
}
