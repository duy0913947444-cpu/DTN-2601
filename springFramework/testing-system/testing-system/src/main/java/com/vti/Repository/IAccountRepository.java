package com.vti.Repository;

import com.vti.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.JpaCountQueryCreator;

public interface IAccountRepository  extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);

    boolean existsByEmailAndIdNot(String email, Integer id);

    boolean existsByUserNameAndIdNot(String userName, Integer id);
}
