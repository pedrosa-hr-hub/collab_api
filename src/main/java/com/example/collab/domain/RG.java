package com.example.collab.domain;

import lombok.Value;

@Value
public class RG {
    String rg;

    public RG(String rg) {

        // Validação de valores em branco ou vazios
        if (rg == null || rg.isBlank()) {
            throw new IllegalArgumentException("RG deve ser informado");
        }

        // Limpa a formatação
        String cleanedRG = rg.replaceAll("\\D", "");

        // Validação de tamanho do RG
        if (cleanedRG.length() < 5 || cleanedRG.length() > 12) {
            throw new IllegalArgumentException("RG deve ter entre 5 e 12 dígitos após limpar a formatação");
        }

        // Validação de digitos iguais
        if (cleanedRG.matches("(\\d)\\1+")) {
            throw new IllegalArgumentException("RG não pode conter todos os dígitos iguais");
        }

        this.rg = cleanedRG;
    }
}
