package com.vti.From;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountFrom {
    //check validation xem lai record b4
    private String email;
    private String userName;
    private String fullName;
    private String password;
    private Integer departmentId;
    private Integer positionId;
}
