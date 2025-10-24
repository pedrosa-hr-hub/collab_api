package com.example.collab.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collab.domain.Agencia;
import com.example.collab.domain.Banco;
import com.example.collab.domain.Conta;
import com.example.collab.domain.Email;
import com.example.collab.domain.Telefone;
import com.example.collab.domain.TipoConta;
import com.example.collab.domain.model.Collaborator;
import com.example.collab.dto.CollaboratorDTO;
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
        existingCollaborator.setEmail(new Email(collaboratorDTO.Email()));
        existingCollaborator.setTelefone(new Telefone(collaboratorDTO.Telefone()));
        existingCollaborator.setEndereco(collaboratorDTO.Endereco());
        existingCollaborator.setTipoConta(new TipoConta(collaboratorDTO.TipoConta()));
        existingCollaborator.setBanco(new Banco(collaboratorDTO.Banco()));
        existingCollaborator.setAgencia(new Agencia(collaboratorDTO.Agencia()));
        existingCollaborator.setConta(new Conta(collaboratorDTO.Conta()));
        existingCollaborator.setContatoEmergencia(collaboratorDTO.ContatoEmergencia());
        existingCollaborator.setTelefoneEmergencia(new Telefone(collaboratorDTO.TelefoneEmergencia()));
        existingCollaborator.setEscolaridade(collaboratorDTO.Escolaridade());
        existingCollaborator.setCurso(collaboratorDTO.Curso());
        existingCollaborator.setObservacoes(collaboratorDTO.Observacoes());

        Collaborator updatedCollaborator = collaboratorRepository.save(existingCollaborator);

        return modelMapper.map(updatedCollaborator, CollaboratorDTO.class);
    }

}
