package com.vti.Service.Impl;

import com.vti.Entity.Account;
import com.vti.Repository.IAccountRepository;
import com.vti.Repository.IDepartmentRepository;
import com.vti.Service.IAccountService;
import com.vti.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Object createAccount(Account account) {
        if(!Utils.checkEmail(account.getEmail())){
            throw new RuntimeException("Email ko hop le!!");
        }
        if(Utils.checkString(account.getUserName())){
            throw new RuntimeException("User name is not null!!");
        }
        if(Utils.checkString(account.getFullName())){
            throw new RuntimeException("Full name is not null!!");
        }
        if(accountRepository.existsByEmail(account.getEmail())){
            throw new RuntimeException("Email was exist!!");
        }
        if(accountRepository.existsByUserName(account.getUserName())){
            throw new RuntimeException("User name was exist!!");
        }
        if(!departmentRepository.existsById(account.getDepartmentId())){
            throw new RuntimeException("Department id was not exist!!");
        }
        account.setPositionId(1);
        account.setCreateDate(LocalDate.now());
        return accountRepository.save(account);
    }

    @Override
    public void deleteById(Integer id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account updateAccount(Integer id, Account account) {
        if(!accountRepository.existsById(id)){
            throw new RuntimeException("account id was not exist!!");
        }
        if(!departmentRepository.existsById(account.getDepartmentId())){
            throw new RuntimeException("Department id was not exist!!");
        }
        if(Objects.nonNull(account.getEmail())){
            if(!Utils.checkEmail(account.getEmail())){
                throw new RuntimeException("Email ko hop le!!");
            }
            if(accountRepository.existsByEmailAndIdNot(account.getEmail(), id)){
                throw new RuntimeException("Email was exist!!");
            }
        }
        if(Objects.nonNull(account.getUserName())){
            if(Utils.checkString(account.getUserName())){
                throw new RuntimeException("User name is not empty!!");
            }
            if(accountRepository.existsByUserNameAndIdNot(account.getUserName(), id)){
                throw new RuntimeException("User name was exist!!");
            }
        }
        if(Objects.nonNull(account.getFullName())){
            if(Utils.checkString(account.getFullName())){
                throw new RuntimeException("Full name is not empty!!");
            }
        }
        account.setPositionId(1);
        account.setId(id);
        return accountRepository.save(account);
    }
}
