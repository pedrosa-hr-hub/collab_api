package com.example.collab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.collab.domain.model.Department;

public interface DeparmentRepository extends JpaRepository <Department, Long>{}
