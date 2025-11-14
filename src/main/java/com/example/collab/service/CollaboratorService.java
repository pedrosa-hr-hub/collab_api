package com.example.collab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collab.domain.model.Collaborator;
import com.example.collab.domain.valueobject.document.*;
import com.example.collab.domain.valueobject.banking.*;
import com.example.collab.dto.request.CollaboratorRequestDTO;
import com.example.collab.dto.response.CollaboratorResponseDTO;
import com.example.collab.exception.business.BadRequestException;
import com.example.collab.exception.domain.InvalidCollaboratorException;
import com.example.collab.exception.domain.NotFoundCollaboratorException;
import com.example.collab.mapper.CollaboratorMapper;
import com.example.collab.repository.CollaboratorRepository;
import com.example.collab.service.validation.CollaboratorValidator;

@Service
public class CollaboratorService {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private CollaboratorValidator collaboratorValidator;

    @Autowired
    private CollaboratorMapper collaboratorMapper;

    public CollaboratorResponseDTO createCollaborator(CollaboratorRequestDTO req) {

        collaboratorValidator.validateNewCollaboratorDocuments(
                req.getCPF(),
                req.getRG(),
                req.getCNH(),
                req.getPIS(),
                req.getWorkWallet(),
                req.getVoterRegistration());

        collaboratorValidator.validateNewCollaboratorBank(
                req.getAccount(),
                req.getPix());

        Collaborator collaborator = collaboratorMapper.toEntity(req);

        if (collaborator != null) {

            Collaborator savedCollaborator = collaboratorRepository.save(collaborator);

            return collaboratorMapper.toResponse(savedCollaborator);

        }

        throw new InvalidCollaboratorException("Error creating collaborator");

    }

    public List<CollaboratorResponseDTO> getAllCollaborators() {

        List<Collaborator> collaborators = collaboratorRepository.findAll();

        if (collaborators.isEmpty()) {

            throw new NotFoundCollaboratorException("Collaborators not found");

        }
        return collaborators.stream()

                .map(collaborator -> collaboratorMapper.toResponse(collaborator)).toList();

    }

    public CollaboratorResponseDTO getCollaboratorByRegistration(Integer registration) {

        Collaborator collaborator = collaboratorRepository.findByRegistration(registration)
                .orElseThrow(() -> new BadRequestException("Registration not found"));

        return collaboratorMapper.toResponse(collaborator);

    }

    public CollaboratorResponseDTO getCollaboratorByCPF(String cpfString) {

        CPF cpf = new CPF(cpfString);

        Collaborator collaborator = collaboratorRepository.findByCPF(cpf)
                .orElseThrow(() -> new BadRequestException("CPF not found"));

        return collaboratorMapper.toResponse(collaborator);

    }

    public List<CollaboratorResponseDTO> getCollaboratorByName(String name) {

        List<Collaborator> collaborators = collaboratorRepository.findByName(name);

        if (collaborators.isEmpty()) {

            throw new NotFoundCollaboratorException("Name not found");

        }

        return collaborators.stream()
                .map(collaborator -> collaboratorMapper.toResponse(collaborator))
                .toList();
    }

    public List<CollaboratorResponseDTO> getCollaboratorByDepartment(String department) {

        List<Collaborator> collaborators = collaboratorRepository.findByDepartment(department);

        if (collaborators.isEmpty()) {

            throw new NotFoundCollaboratorException("Department not found");

        }

        return collaborators.stream()
                .map(collaborator -> collaboratorMapper.toResponse(collaborator))
                .toList();
    }

    public List<CollaboratorResponseDTO> getCollaboratorByPosition(String position) {

        List<Collaborator> collaborators = collaboratorRepository.findByPosition(position);

        if (collaborators.isEmpty()) {

            throw new NotFoundCollaboratorException("Position not found");

        }

        return collaborators.stream()
                .map(collaborator -> collaboratorMapper.toResponse(collaborator))
                .toList();
    }

    public List<CollaboratorResponseDTO> getCollaboratorByBank(String bankName) {

        Bank bank = new Bank(bankName);

        List<Collaborator> collaborators = collaboratorRepository.findByBank(bank);

        if (collaborators.isEmpty()) {

            throw new NotFoundCollaboratorException("Bank not found");

        }

        return collaborators.stream()
                .map(collaborator -> collaboratorMapper.toResponse(collaborator))
                .toList();
    }

    public String deleteCollaboratorByRegistration(Integer registration) {

        Collaborator collaborator = collaboratorRepository.findByRegistration(registration).orElseThrow(
                () -> new BadRequestException("Collaborator not found with registration: " + registration));

        String name = collaborator.getName();

        collaboratorRepository.delete(collaborator);

        return name;

    }

    public CollaboratorResponseDTO updateCollaborator(Integer registration, CollaboratorRequestDTO req) {

        Collaborator existingCollaborator = collaboratorRepository.findByRegistration(registration).orElseThrow(
                () -> new BadRequestException("Collaborator not found with registration: " + registration));

        collaboratorMapper.updateEntity(existingCollaborator, req);

        Collaborator updatedCollaborator = collaboratorRepository.save(existingCollaborator);

        return collaboratorMapper.toResponse(updatedCollaborator);

    }

}
