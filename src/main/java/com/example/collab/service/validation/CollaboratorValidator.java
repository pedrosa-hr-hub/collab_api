package com.example.collab.service.validation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.collab.repository.CollaboratorRepository;

@Component
public class CollaboratorValidator {

    private CollaboratorRepository collaboratorRepository;

    public void validateNewCollaboratorDocuments(String cpf, String RG, String CNH, String PIS, String carteiraTrabalho,
            String tituloEleitor) {

        if (collaboratorRepository.findByCPF(cpf).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já cadastrado");
        }

        if (collaboratorRepository.findByRG(RG).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "RG já cadastrado");
        }

        if (collaboratorRepository.findByCNH(CNH).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CNH já cadastrada");
        }

        if (collaboratorRepository.findByPIS(PIS).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PIS já cadastrado");
        }

        if (collaboratorRepository.findByCarteiraTrabalho(carteiraTrabalho).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Carteira de Trabalho já cadastrada");
        }

        if (collaboratorRepository.findByTituloEleitor(tituloEleitor).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Título de Eleitor já cadastrado");
        }

    }

    public void validateNewCollaboratorBank(String banco, String agencia, String conta, String tipoConta, String pix) {

        if (collaboratorRepository.findByBanco(banco).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Banco já cadastrado");
        }

        if (collaboratorRepository.findByAgencia(agencia).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agência já cadastrada");
        }

        if (collaboratorRepository.findByConta(conta).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta já cadastrada");
        }

        if (collaboratorRepository.findByPix(pix).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pix já cadastrado");
        }

    }

}
