package com.vti.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`group_account`")
public class GroupAccount {
    @Id
    @Column(name = "group_account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increament
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @CreationTimestamp
    @Column(name = "join_date", columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime joinDate;
}
