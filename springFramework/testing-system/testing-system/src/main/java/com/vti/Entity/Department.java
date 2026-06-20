package com.vti.Entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Department")

public class Department {
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increament
    private Integer id;

    @Column(name = "department_name", nullable = false, unique = true, length = 100)
    private String name;
}
