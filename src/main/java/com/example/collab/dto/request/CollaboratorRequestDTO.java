package com.example.collab.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class CollaboratorRequestDTO {

    // Identificação
    @NotBlank
    @Size(max = 120)
    private String nome;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @Size(max = 30)
    private String estadoCivil;

    @Size(max = 60)
    private String nacionalidade;

    // Contato
    @Email
    @Size(max = 180)
    private String email;

    @Size(max = 20)
    private String telefone;

    @Size(max = 255)
    private String endereco;

    // Profissional
    @Size(max = 120)
    private String cargo;

    @Size(max = 120)
    private String departamento;

    @PastOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAdmissao;

    @Size(max = 60)
    private String tipoContrato;

    @PositiveOrZero
    private Double salario;

    @NotNull
    private Integer matricula;

    @Size(max = 20)
    private String cargaHoraria;

    // Bancárias
    @Size(max = 3)
    private String banco;

    @Size(max = 10)
    private String agencia;

    @Size(max = 20)
    private String conta;

    @Size(max = 20)
    private String tipoConta;

    @Size(max = 100)
    private String pix;

    // Documentos
    @Size(max = 20)
    private String carteiraTrabalho;

    @Size(max = 20)
    private String tituloEleitor;

    @Size(max = 40)
    private String certificadoReservista;

    @Size(max = 20)
    private String PIS;

    @Size(max = 20)
    private String CNH;

    @Size(max = 14)
    private String CPF;

    @Size(max = 20)
    private String RG;

    // Emergência
    @Size(max = 120)
    private String contatoEmergencia;

    @Size(max = 20)
    private String telefoneEmergencia;

    // Adicionais
    @Size(max = 60)
    private String escolaridade;

    @Size(max = 120)
    private String curso;

    @Size(max = 120)
    private String observacoes;
}