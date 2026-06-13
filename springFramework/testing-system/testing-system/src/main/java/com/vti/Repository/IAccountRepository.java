package com.vti.Repository;

import com.vti.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository  extends JpaRepository<Account, Integer> {
    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);

    boolean existsByEmailAndIdNot(String email, Integer id);

    boolean existsByUserNameAndIdNot(String userName, Integer id);
}
