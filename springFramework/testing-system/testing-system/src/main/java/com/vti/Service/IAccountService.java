package com.vti.Service;


import com.vti.DTO.AccountDTO;
import com.vti.Entity.Account;
import com.vti.From.AccountFrom;
import com.vti.From.AccountSearchFrom;

import java.util.List;

public interface IAccountService{
    List<AccountDTO> findAll(AccountSearchFrom accountSearchFrom);

    Account createAccount(AccountFrom createAccountFrom);

    void deleteById(Integer id);

    void updateAccount(Integer id, AccountFrom accountFrom);
}
