package com.example.collab.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.collab.domain.model.Collaborator;
import com.example.collab.domain.valueobject.banking.*;
import com.example.collab.domain.valueobject.document.*;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

    Optional<Collaborator> findByRegistration(Integer registration);

    List<Collaborator> findByDepartment(String department);

    List<Collaborator> findByPosition(String position);

    Optional<Collaborator> findByCPF(CPF CPF);

    List<Collaborator> findByBank(Bank bank);

    Optional<Collaborator> findByAccount(Account account);

    Optional<Collaborator> findByPix(PIX pix);

    List<Collaborator> findByName(String name);

    Optional<Collaborator> findByEmail(String email);

}
