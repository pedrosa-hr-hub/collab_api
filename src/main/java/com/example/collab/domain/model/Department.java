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

    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Id
    @Getter
    @Setter
    @Column(unique = true)
    private Integer number;

    @Getter
    @Setter
    private Date initial_date;

    @Getter
    @Setter
    private Date end_date;

    @Getter
    @Setter
    private Integer manager_registration;

    @Getter
    @Setter
    private List<Integer> manager_suport_registration;

}
