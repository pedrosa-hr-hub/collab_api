package com.example.collab.service.validation; 

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.collab.repository.DepartmentRepository;
import com.example.collab.repository.CollaboratorRepository;

@Component
public class DeparmentValidation {

    private DepartmentRepository departmentRepository;

    private CollaboratorRepository collaboratorRepository;

    @Autowired
    public DeparmentValidation(DepartmentRepository departmentRepository, CollaboratorRepository collaboratorRepository){

        this.departmentRepository = departmentRepository;
        this.collaboratorRepository = collaboratorRepository;

    }

    public void validateDepartmentCheff(Integer registration, Integer number){

        if(collaboratorRepository.findByRegistration(registration).isEmpty() && departmentRepository.findByNumber(number).isEmpty){

           throw new RuntimeException("Error");

        } 


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
