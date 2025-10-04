package com.example.collab.model;

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
    private String Nome;

    @Getter
    @Setter
    private Date DataNascimento;

    @Getter
    @Setter
    private String EstadoCivil;

    @Getter
    @Setter
    private String Nacionalidade;

    // ------------------------------------------------------------------//

    // Informações de Contato

    @Getter
    @Setter
    private String Email;

    @Getter
    @Setter
    private String Telefone;

    @Getter
    @Setter
    private String Endereco;

    // ------------------------------------------------------------------//

    // Informações Profissionais

    @Getter
    @Setter
    private String Cargo;

    @Getter
    @Setter
    private String Departamento;

    @Getter
    @Setter
    private Date DataAdmissao;

    @Getter
    @Setter
    private String TipoContrato;

    @Getter
    @Setter
    private Double Salario;

    @Getter
    @Setter
    private String Matricula;

    @Getter
    @Setter
    private String CargaHoraria;

    // ------------------------------------------------------------------//

    // Informações Bancárias

    @Getter
    @Setter
    private String Banco;

    @Getter
    @Setter
    private String Agencia;

    @Getter
    @Setter
    private String Conta;

    @Getter
    @Setter
    private String TipoConta;

    @Getter
    @Setter
    private String Pix;

    // ------------------------------------------------------------------//

    // Dcocumentos

    @Getter
    @Setter
    private String CarteiraTrabalho;

    @Getter
    @Setter
    private String TituloEleitor;

    @Getter
    @Setter
    private String CertificadoReservista;

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
    private String ContatoEmergencia;

    @Getter
    @Setter
    private String TelefoneEmergencia;

    // ------------------------------------------------------------------//

    // Informações Adicionais

    @Getter
    @Setter
    private String Escolaridade;

    @Getter
    @Setter
    private String Curso;

    @Getter
    @Setter
    private String Observacoes;
}
