package com.vti.From;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountSearchFrom {
    private String email;
    private String userName;
    private String fullName;
    private String departmentName;
    private String positionName;
}
