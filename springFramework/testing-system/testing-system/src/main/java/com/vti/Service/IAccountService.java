package com.vti.Service;


import com.vti.DTO.AccountDTO;
import com.vti.Entity.Account;
import com.vti.From.AccountFrom;
import com.vti.From.AccountSearchFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService{
    Page<AccountDTO> findAll(Pageable pageable , AccountSearchFrom accountSearchFrom);

    Account createAccount(AccountFrom createAccountFrom);

    void deleteById(Integer id);

    void updateAccount(Integer id, AccountFrom accountFrom);
}
