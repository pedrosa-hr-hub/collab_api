package com.example.collab.domain;

import lombok.Value;

@Value
public class Banco {
    String codigo;

    public Banco(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código do banco deve ser informado");
        }
        if (!codigo.matches("\\d{3}")) {
            throw new IllegalArgumentException("Código do banco deve conter exatamente 3 dígitos");
        }
        this.codigo = codigo;
    }
}