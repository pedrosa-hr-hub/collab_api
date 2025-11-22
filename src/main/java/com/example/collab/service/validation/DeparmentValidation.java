package com.example.collab.service.validation; 

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.collab.repository.DepartmentRepository;

@Component
public class DeparmentValidation {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DeparmentValidation(DepartmentRepository departmentRepository){

        this.departmentRepository = departmentRepository;

    }

    public void validateDepartmentCheff(String registration){

    }

    public void validateDepartmentSupportCheff(String registration){

    }

    public void validateDepartmentName(String name){

    }

    public void validateDepartmentNumber(Integer number){

    }

    public void validateDeparmenDate(Date intial_date, Date end_date){

    }
}
