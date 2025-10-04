package com.example.collab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.collab.model.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

}
