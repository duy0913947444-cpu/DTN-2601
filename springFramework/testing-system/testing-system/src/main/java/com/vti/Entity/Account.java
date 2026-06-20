package com.vti.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name = "password", length = 100)
    private String password;

    @CreationTimestamp
    @Column(name = "create_date", columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
}
