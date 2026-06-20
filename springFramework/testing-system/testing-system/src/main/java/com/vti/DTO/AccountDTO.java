package com.vti.DTO;

import com.vti.Entity.Account;
import com.vti.Enum.PositionName;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private String email;
    private String userName;
    private String fullName;
    private String departmentName;
    private PositionName positionName;
    private LocalDateTime createDate;

    public AccountDTO(Account account) {
        this.email = account.getEmail();
        this.userName = account.getUserName();
        this.fullName = account.getFullName();
        if(Objects.nonNull(account.getDepartment())){
            this.departmentName = account.getDepartment().getName();
        }
        if(Objects.nonNull(account.getDepartment())){
            this.positionName = account.getPosition().getName();
        }
        this.createDate = account.getCreateDate();
    }
}
