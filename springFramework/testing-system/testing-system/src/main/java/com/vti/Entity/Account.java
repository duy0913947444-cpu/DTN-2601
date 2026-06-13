package com.vti.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increament
    private Integer id;
    @Column(name = "email", unique = true, length = 100)
    private String email;
    @Column(name = "user_name", unique = true, length = 100)
    private String userName;
    @Column(name = "full_name", length = 100)
    private String fullName;
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "position_id")
    private Integer positionId;
}
