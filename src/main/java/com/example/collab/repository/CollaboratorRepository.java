package com.example.collab.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.collab.model.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

    Optional<Collaborator> findByMatricula(String matricula);

    Optional<Collaborator> findByDepartamento(String departamento);

    Optional<Collaborator> findByCargo(String cargo);

    Optional<Collaborator> findByTipoContrato(String tipoContrato);

    Optional<Collaborator> findByCargaHoraria(String cargaHoraria);

    Optional<Collaborator> findByCPF(String CPF);

    Optional<Collaborator> findByRG(String RG);

    Optional<Collaborator> findByBanco(String banco);

    Optional<Collaborator> findByConta(String conta);

    Optional<Collaborator> findByPix(String pix);

    Optional<Collaborator> findByNome(String nome);

    Optional<Collaborator> findByEmail(String email);

}
