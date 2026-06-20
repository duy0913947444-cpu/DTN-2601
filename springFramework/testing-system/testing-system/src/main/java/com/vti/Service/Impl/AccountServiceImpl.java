package com.vti.Service.Impl;

import com.vti.DTO.AccountDTO;
import com.vti.Entity.Account;
import com.vti.Entity.Department;
import com.vti.Entity.Position;
import com.vti.From.AccountFrom;
import com.vti.From.AccountSearchFrom;
import com.vti.Repository.IAccountRepository;
import com.vti.Repository.IDepartmentRepository;
import com.vti.Repository.IPositionRepository;
import com.vti.Service.IAccountService;
import com.vti.Specification.AccountCustomSpecification;
import com.vti.Utils.Utils;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public Page<AccountDTO> findAll(Pageable pageable , AccountSearchFrom accountSearchFrom) {
        Specification<Account> where = Specification.unrestricted(); // where 1=1
        if(StringUtils.isNotEmpty(accountSearchFrom.getUserName())){
            AccountCustomSpecification userName = new AccountCustomSpecification(
                    "username", accountSearchFrom.getUserName());
            where = where.and(userName);
        }
        if(StringUtils.isNotEmpty(accountSearchFrom.getFullName())){
            AccountCustomSpecification fullName = new AccountCustomSpecification(
                    "fullname", accountSearchFrom.getFullName());
            where = where.and(fullName);
        }
        if(StringUtils.isNotEmpty(accountSearchFrom.getEmail())){
            AccountCustomSpecification email = new AccountCustomSpecification(
                    "email", accountSearchFrom.getEmail());
            where = where.and(email);
        }
        if(StringUtils.isNotEmpty(accountSearchFrom.getDepartmentName())){
            AccountCustomSpecification departmentName = new AccountCustomSpecification(
                    "departmentname", accountSearchFrom.getDepartmentName());
            where = where.and(departmentName);
        }
        if(StringUtils.isNotEmpty(accountSearchFrom.getPositionName())){
            AccountCustomSpecification positionName = new AccountCustomSpecification(
                    "positionname", accountSearchFrom.getPositionName());
            where = where.and(positionName);
        }
        Page<Account> pageAccount = accountRepository.findAll(where, pageable);
        Page<AccountDTO> pageDTO = pageAccount.map(account -> new AccountDTO(account));
//        for (Account account: accountList){
//            accountDTOList.add(modelMapper.map(account, AccountDTO.class));
//        }
        return pageDTO;
    }

    @Override
    @Transactional
    public Account createAccount(AccountFrom createAccountFrom) {
        if(!Utils.checkEmail(createAccountFrom.getEmail())){
            throw new RuntimeException("Email ko hop le!!");
        }
        if(Utils.checkString(createAccountFrom.getUserName())){
            throw new RuntimeException("User name is not null!!");
        }
        if(Utils.checkString(createAccountFrom.getFullName())){
            throw new RuntimeException("Full name is not null!!");
        }
        if(accountRepository.existsByEmail(createAccountFrom.getEmail())){
            throw new RuntimeException("Email was exist!!");
        }
        if(accountRepository.existsByUserName(createAccountFrom.getUserName())){
            throw new RuntimeException("User name was exist!!");
        }
        Department department = departmentRepository.findById(
                createAccountFrom.getDepartmentId()).orElse(null);
        if(Objects.isNull(department)){
            throw new RuntimeException("Department id not found!!");
        }
        Position position = positionRepository.findById(createAccountFrom.getPositionId()).orElse(null);
        if(Objects.isNull(position)){
            throw new RuntimeException("Position id not found!!");
        }
        Account account = new Account();
        account.setUserName(createAccountFrom.getUserName());
        account.setFullName(createAccountFrom.getFullName());
        account.setEmail(createAccountFrom.getEmail());
        account.setPassword(createAccountFrom.getPassword());
        account.setDepartment(department);
        account.setPosition(position);
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        accountRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateAccount(Integer id, AccountFrom accountFrom) {
        Department department = null;
        Position position = null;
        Account account= accountRepository.findById(id).orElse(null);
        if(Objects.isNull(account)){
            throw new RuntimeException("account id was not exist!!");
        }
        if(Objects.nonNull(accountFrom.getDepartmentId())){
            department = departmentRepository.findById(
                    accountFrom.getDepartmentId()).orElse(null);
            if(Objects.isNull(department)){
                throw new RuntimeException("Department id not found!!");
            }
            account.setDepartment(department);
        }
        if(Objects.nonNull(accountFrom.getPositionId())){
            position = positionRepository.findById(accountFrom.getPositionId()).orElse(null);
            if(Objects.isNull(position)){
                throw new RuntimeException("Position id not found!!");
            }
            account.setPosition(position);
        }
        if(Objects.nonNull(accountFrom.getEmail())){
            if(!Utils.checkEmail(accountFrom.getEmail())){
                throw new RuntimeException("Email ko hop le!!");
            }
            if(accountRepository.existsByEmailAndIdNot(accountFrom.getEmail(), id)){
                throw new RuntimeException("Email was exist!!");
            }
            account.setEmail(accountFrom.getEmail());
        }
        if(Objects.nonNull(accountFrom.getUserName())){
            if(Utils.checkString(accountFrom.getUserName())){
                throw new RuntimeException("User name is not empty!!");
            }
            if(accountRepository.existsByUserNameAndIdNot(accountFrom.getUserName(), id)){
                throw new RuntimeException("User name was exist!!");
            }
            account.setUserName(accountFrom.getUserName());
        }
        if(Objects.nonNull(accountFrom.getFullName())){
            if(Utils.checkString(accountFrom.getFullName())){
                throw new RuntimeException("Full name is not empty!!");
            }
            account.setFullName(accountFrom.getFullName());
        }
        account.setId(id);
        accountRepository.save(account);
    }
}
