package com.vti.Entity;

import com.vti.Enum.ArticlePositionNameConverter;
import com.vti.Enum.PositionName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Position")
public class Position {
    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increament
    private Integer id;

    @Convert(converter = ArticlePositionNameConverter.class)
    @Column(name = "position_name", nullable = false)
    private PositionName name;
}












