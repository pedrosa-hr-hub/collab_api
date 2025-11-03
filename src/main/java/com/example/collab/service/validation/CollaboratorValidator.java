package com.example.collab.service.validation;

import org.springframework.stereotype.Component;

import com.example.collab.exception.domain.DuplicatedAccountException;
import com.example.collab.exception.domain.DuplicatedCNHException;
import com.example.collab.exception.domain.DuplicatedCPFException;
import com.example.collab.exception.domain.DuplicatedPISException;
import com.example.collab.exception.domain.DuplicatedPixException;
import com.example.collab.exception.domain.DuplicatedRGException;
import com.example.collab.exception.domain.DuplicatedVoteRegistrationException;
import com.example.collab.exception.domain.DuplicatedWorkWalletException;

import com.example.collab.repository.CollaboratorRepository;

@Component
public class CollaboratorValidator {

    private CollaboratorRepository collaboratorRepository;

    public void validateNewCollaboratorDocuments(String cpf, String RG, String CNH, String PIS, String carteiraTrabalho,
            String tituloEleitor) {

        if (collaboratorRepository.findByCPF(cpf).isPresent()) {

            throw new DuplicatedCPFException("CPF already exists");

        }

        if (collaboratorRepository.findByRG(RG).isPresent()) {

            throw new DuplicatedRGException("RG already exists");

        }

        if (collaboratorRepository.findByCNH(CNH).isPresent()) {

            throw new DuplicatedCNHException("CNH already exists");

        }

        if (collaboratorRepository.findByPIS(PIS).isPresent()) {

            throw new DuplicatedPISException("PIS already exists");

        }

        if (collaboratorRepository.findByCarteiraTrabalho(carteiraTrabalho).isPresent()) {

            throw new DuplicatedWorkWalletException("Work Wallet already exists");

        }

        if (collaboratorRepository.findByTituloEleitor(tituloEleitor).isPresent()) {

            throw new DuplicatedVoteRegistrationException("Vote Registration Title already exists");

        }

    }

    public void validateNewCollaboratorBank(String account, String pix) {

        if (collaboratorRepository.findByAccount(account).isPresent()) {

            throw new DuplicatedAccountException("Account already exists");

        }

        if (collaboratorRepository.findByPix(pix).isPresent()) {

            throw new DuplicatedPixException("Pix already exists");

        }

    }

}
