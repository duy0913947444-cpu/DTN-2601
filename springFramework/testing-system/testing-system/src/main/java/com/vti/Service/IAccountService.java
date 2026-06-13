package com.vti.Service;


import com.vti.Entity.Account;

import java.util.List;

public interface IAccountService{
    List<Account> findAll();

    Object createAccount(Account account);

    void deleteById(Integer id);

    Account updateAccount(Integer id, Account account);
}
