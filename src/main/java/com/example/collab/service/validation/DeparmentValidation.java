package com.example.collab.service.validation; 

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
}
