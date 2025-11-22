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

    public void validateDepartmentCheff(Integer registration, boolean manager){

        if(collaboratorRepository.findByRegistrationAndCheff(registration, true).isPresent()){
            
            throw new RuntimeException("This collaborator does not act as a manager.");

          }

        }

    public void validateDepartmentSupportCheff(String registration){

    }

    public void validateDepartmentName(String name){

        if(departmentRepository.findByName(name).isPresent()){

            throw new RuntimeException("Name already exists");

        }

    }

    public void validateDepartmentNumber(Integer number){

        if(departmentRepository.findByNumber(number).isPresent()){

            throw new RuntimeException("Number already exists");

        }
    }

    public void validateDeparmenDate(Date intial_date, Date end_date){

    }
}
