package com.example.collab.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.collab.domain.model.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

    Optional<Collaborator> findByMatricula(Integer matricula);

    Optional<Collaborator> findByDepartamento(String departamento);

    Optional<Collaborator> findByCargo(String cargo);

    Optional<Collaborator> findByTipoContrato(String tipoContrato);

    Optional<Collaborator> findByCargaHoraria(String cargaHoraria);

    Optional<Collaborator> findByCPF(String CPF);

    Optional<Collaborator> findByRG(String RG);

    Optional<Collaborator> findByCNH(String CNH);

    Optional<Collaborator> findByPIS(String PIS);

    Optional<Collaborator> findByCarteiraTrabalho(String carteiraTrabalho);

    Optional<Collaborator> findByTituloEleitor(String tituloEleitor);

    Optional<Collaborator> findByBank(String bank);

    Optional<Collaborator> findByAccount(String account);

    Optional<Collaborator> findByPix(String pix);

    Optional<Collaborator> findByName(String name);

    Optional<Collaborator> findByEmail(String email);

    void deleteByMatricula(Integer matricula);

}
