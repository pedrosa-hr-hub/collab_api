package com.example.collab.service;

import org.springframework.stereotype.Service;

import com.example.collab.repository.DepartmentRepository;
import com.example.collab.service.validation.DepartmentValidator;
import com.example.collab.mapper.DepartmentMapper;

@Service
public class DeparmentService {

    private DepartmentRepository departmentRepository;

    private DepartmentValidator departmentValidator;

    private DepartmentMapper departmentMapper;

}
