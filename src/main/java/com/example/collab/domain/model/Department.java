package com.example.collab.domain.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer number;

    @Getter
    @Setter
    private Date initial_date;

    @Getter
    @Setter
    private Date end_date;

    @Getter
    @Setter
    private Integer chef_registration;

    @Getter
    @Setter
    private List<Integer> chef_suport_registration;

}
