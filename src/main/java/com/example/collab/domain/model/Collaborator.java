package com.example.collab.domain.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Collaborator {

    // Informações Pessoais

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private Date dataNascimento;

    @Getter
    @Setter
    private String estadoCivil;

    @Getter
    @Setter
    private String nacionalidade;

    // ------------------------------------------------------------------//

    // Informações de Contato

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String telefone;

    @Getter
    @Setter
    private String endereco;

    // ------------------------------------------------------------------//

    // Informações Profissionais

    @Getter
    @Setter
    private String cargo;

    @Getter
    @Setter
    private String departamento;

    @Getter
    @Setter
    private Date dataAdmissao;

    @Getter
    @Setter
    private String tipoContrato;

    @Getter
    @Setter
    private Double salario;

    @Getter
    @Setter
    private Integer matricula;

    @Getter
    @Setter
    private String cargaHoraria;

    // ------------------------------------------------------------------//

    // Informações Bancárias

    @Getter
    @Setter
    private String banco;

    @Getter
    @Setter
    private String agencia;

    @Getter
    @Setter
    private String conta;

    @Getter
    @Setter
    private String tipoConta;

    @Getter
    @Setter
    private String pix;

    // ------------------------------------------------------------------//

    // Dcocumentos

    @Getter
    @Setter
    private String carteiraTrabalho;

    @Getter
    @Setter
    private String tituloEleitor;

    @Getter
    @Setter
    private String certificadoReservista;

    @Getter
    @Setter
    private String PIS;

    @Getter
    @Setter
    private String CNH;

    @Getter
    @Setter
    private String CPF;

    @Getter
    @Setter
    private String RG;

    // ------------------------------------------------------------------//

    // Informações de Emergência

    @Getter
    @Setter
    private String contatoEmergencia;

    @Getter
    @Setter
    private String telefoneEmergencia;

    // ------------------------------------------------------------------//

    // Informações Adicionais

    @Getter
    @Setter
    private String escolaridade;

    @Getter
    @Setter
    private String curso;

    @Getter
    @Setter
    private String observacoes;
}
