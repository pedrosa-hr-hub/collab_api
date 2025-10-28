package com.example.collab.domain.valueobject.documento;

import lombok.Value;

@Value
public class CarteiraTrabalho {
    String numero;

    public CarteiraTrabalho(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Carteira de Trabalho deve ser informada");
        }

        // Remove caracteres não numéricos
        String cleanedNumero = numero.replaceAll("\\D", "");

        // Valida o tamanho da Carteira de Trabalho
        if (cleanedNumero.length() != 11) {
            throw new IllegalArgumentException(
                    "Carteira de Trabalho deve conter 11 dígitos (7 para o número e 4 para a série)");
        }

        // Validação para evitar números com todos os dígitos iguais
        if (cleanedNumero.matches("(\\d)\\1+")) {
            throw new IllegalArgumentException("Carteira de Trabalho não pode conter todos os dígitos iguais");
        }

        this.numero = cleanedNumero;
    }
}