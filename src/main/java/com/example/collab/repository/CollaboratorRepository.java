package com.example.collab.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.collab.domain.model.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

    Optional<Collaborator> findByRegistration(Integer registration);

    Optional<Collaborator> findByDepartment(String department);

    Optional<Collaborator> findByPosition(String position);

    Optional<Collaborator> findByContractType(String contractType);

    Optional<Collaborator> findByWorkload(String workload);

    Optional<Collaborator> findByCPF(String CPF);

    Optional<Collaborator> findByRG(String RG);

    Optional<Collaborator> findByCNH(String CNH);

    Optional<Collaborator> findByPIS(String PIS);

    Optional<Collaborator> findByWorkWallet(String workWallet);

    Optional<Collaborator> findByVoterRegistration(String voterRegistration);

    Optional<Collaborator> findByBank(String bank);

    Optional<Collaborator> findByAccount(String account);

    Optional<Collaborator> findByPix(String pix);

    List<Collaborator> findByName(String name);

    Optional<Collaborator> findByEmail(String email);

    void deleteByMatricula(Integer matricula);

}
