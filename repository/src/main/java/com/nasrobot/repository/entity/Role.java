package com.nasrobot.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

}