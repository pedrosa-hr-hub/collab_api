package com.example.collab.service.validation; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.collab.repository.DepartmentRepository;
import com.example.collab.repository.CollaboratorRepository;

@Component
public class DepartmentValidator {

    private DepartmentRepository departmentRepository;

    private CollaboratorRepository collaboratorRepository;

    @Autowired
    public DepartmentValidator(DepartmentRepository departmentRepository, CollaboratorRepository collaboratorRepository){

        this.departmentRepository = departmentRepository;
        this.collaboratorRepository = collaboratorRepository;

    }

    public void validateDepartmentManager(Integer registration){

        if(collaboratorRepository.findByRegistrationAndManager(registration, true).isEmpty()){

            throw new RuntimeException("This collaborator does not act as a manager.");

          }

    }

    public void validateDepartmentSupportManager(Integer registration){

        if(collaboratorRepository.findByRegistrationAndSupportManager(registration, true).isEmpty()){

            throw new RuntimeException("This collaborator does not act as a support manager");

        }

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

}
