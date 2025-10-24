package com.example.collab.domain.model;

import java.sql.Date;

import com.example.collab.domain.CNH;
import com.example.collab.domain.CPF;
import com.example.collab.domain.CarteiraTrabalho;
import com.example.collab.domain.Email;
import com.example.collab.domain.RG;
import com.example.collab.domain.TituloEleitor;
import com.example.collab.domain.PIS;

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
    private Email email;

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
    private CarteiraTrabalho carteiraTrabalho;

    @Getter
    @Setter
    private TituloEleitor tituloEleitor;

    @Getter
    @Setter
    private String certificadoReservista;

    @Getter
    @Setter
    private PIS PIS;

    @Getter
    @Setter
    private CNH CNH;

    @Getter
    @Setter
    private CPF CPF;

    @Getter
    @Setter
    private RG RG;

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
