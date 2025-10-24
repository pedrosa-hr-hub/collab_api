package com.example.collab.domain;

import lombok.Value;

@Value
public class TipoConta {
    String tipo;

    public TipoConta(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("Tipo de conta deve ser informado");
        }
        if (!tipo.equalsIgnoreCase("Corrente") &&
                !tipo.equalsIgnoreCase("Poupança") &&
                !tipo.equalsIgnoreCase("Salário")) {
            throw new IllegalArgumentException("Tipo de conta deve ser 'Corrente', 'Poupança' ou 'Salário'");
        }
        this.tipo = tipo;
    }
}