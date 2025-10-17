package com.example.collab.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collab.dto.CollaboratorDTO;
import com.example.collab.model.Collaborator;
import com.example.collab.repository.CollaboratorRepository;
import com.example.collab.service.validation.CollaboratorValidator;

@Service
public class CollabService {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private CollaboratorValidator collaboratorValidator;

    @Autowired
    private ModelMapper modelMapper;

    public CollaboratorDTO createCollaborator(CollaboratorDTO collaboratorDTO) {

        collaboratorValidator.validateNewCollaboratorDocuments(
                collaboratorDTO.CPF(),
                collaboratorDTO.RG(),
                collaboratorDTO.CNH(),
                collaboratorDTO.PIS(),
                collaboratorDTO.CarteiraTrabalho(),
                collaboratorDTO.TituloEleitor());

        collaboratorValidator.validateNewCollaboratorBank(
                collaboratorDTO.Banco(),
                collaboratorDTO.Conta(),
                collaboratorDTO.Pix());

        Collaborator collaborator = modelMapper.map(collaboratorDTO, Collaborator.class);

        Collaborator savedCollaborator = collaboratorRepository.save(collaborator);

        return modelMapper.map(savedCollaborator, CollaboratorDTO.class);
    }

    public List<CollaboratorDTO> getAllCollaborators() {
        List<Collaborator> collaborators = collaboratorRepository.findAll();

        if (collaborators.isEmpty()) {
            throw new RuntimeException("Nenhum colaborador encontrado");
        }

        return collaborators.stream()
                .map(collaborator -> modelMapper.map(collaborator, CollaboratorDTO.class))
                .toList();
    }

    public CollaboratorDTO getCollaboratorByMatricula(Integer matricula) {

        Collaborator collaborator = collaboratorRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Matricula não encontrada"));

        return modelMapper.map(collaborator, CollaboratorDTO.class);
    }

    public CollaboratorDTO getCollaboratorByCPF(String CPF) {

        Collaborator collaborator = collaboratorRepository.findByCPF(CPF)
                .orElseThrow(() -> new RuntimeException("CPF não encontrado"));

        return modelMapper.map(collaborator, CollaboratorDTO.class);
    }

    public CollaboratorDTO getCollaboratorByNome(String nome) {

        Collaborator collaborator = collaboratorRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Nome não encontrado"));

        return modelMapper.map(collaborator, CollaboratorDTO.class);
    }

    public void deleteCollaboratorbyMatricula(Integer matricula) {

        Collaborator collaborator = collaboratorRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado com a matrícula: " + matricula));

        collaboratorRepository.delete(collaborator);
    }

    public CollaboratorDTO updateCollaborator(Integer matricula, CollaboratorDTO collaboratorDTO) {

        Collaborator existingCollaborator = collaboratorRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado com a matrícula: " + matricula));

        existingCollaborator.setNome(collaboratorDTO.nome());
        existingCollaborator.setEstadoCivil(collaboratorDTO.EstadoCivil());
        existingCollaborator.setEmail(collaboratorDTO.Email());
        existingCollaborator.setTelefone(collaboratorDTO.Telefone());
        existingCollaborator.setEndereco(collaboratorDTO.Endereco());
        existingCollaborator.setTipoConta(collaboratorDTO.TipoConta());
        existingCollaborator.setBanco(collaboratorDTO.Banco());
        existingCollaborator.setAgencia(collaboratorDTO.Agencia());
        existingCollaborator.setConta(collaboratorDTO.Conta());
        existingCollaborator.setContatoEmergencia(collaboratorDTO.ContatoEmergencia());
        existingCollaborator.setTelefoneEmergencia(collaboratorDTO.TelefoneEmergencia());
        existingCollaborator.setEscolaridade(collaboratorDTO.Escolaridade());
        existingCollaborator.setCurso(collaboratorDTO.Curso());
        existingCollaborator.setObservacoes(collaboratorDTO.Observacoes());

        Collaborator updatedCollaborator = collaboratorRepository.save(existingCollaborator);

        return modelMapper.map(updatedCollaborator, CollaboratorDTO.class);
    }

}
