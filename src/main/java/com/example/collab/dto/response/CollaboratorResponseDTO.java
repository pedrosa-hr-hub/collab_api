package com.example.collab.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CollaboratorResponseDTO {

    // Gerados pelo sistema
    private Long id;

    // Identificação
    private String nome;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    private String estadoCivil;
    private String nacionalidade;

    // Contato
    private String email;
    private String telefone;
    private String endereco;

    // Profissional
    private String cargo;
    private String departamento;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAdmissao;

    private String tipoContrato;
    private Double salario; // se sensível, omitir aqui
    private Integer matricula;
    private String cargaHoraria;

    // Bancárias (avalie expor ou não)
    private String bank;
    private String agency;
    private String account;
    private String typeAccount;
    private String pix;

    // Documentos (avalie expor ou mascarar)
    private String workWallet;
    private String voterRegistration;
    private String certificadoReservista;
    private String PIS;
    private String CNH;
    private String CPF;
    private String RG;

    // Emergência
    private String contatoEmergencia;
    private String phoneEmergency;

    // Adicionais
    private String escolaridade;
    private String curso;
    private String observacoes;
}