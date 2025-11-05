package com.example.collab.domain.valueobject.documento;

import com.example.collab.exception.domain.InvalidDocumentException;

import lombok.Value;

@Value
public class VoterRegistration {
    
    String voteId;

    public VoterRegistration(String voteId) {

        if (voteId == null || voteId.isBlank()) {

            throw new InvalidDocumentException("Voter Registration Card must be provided.");

        }

        // Remove caracteres não numéricos
        String cleanedVoteId = voteId.replaceAll("\\D", "");

        // Valida o tamanho do Título de Eleitor
        if (cleanedVoteId.length() != 12) {

            throw new InvalidDocumentException("Voter Registration Card must contain 12 digits.");

        }

        // Valida os dígitos verificadores
        if (!isValidTituloEleitor(cleanedVoteId)) {

            throw new InvalidDocumentException("Invalid Voter Registration Card: " + voteId);

        }

        this.voteId = cleanedVoteId;

    }

    private boolean isValidTituloEleitor(String voteId) {

        // Multiplicadores para o primeiro dígito verificador
        int[] weights1 = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3 };

        int sum1 = 0;

        // Calcula o primeiro dígito verificador
        for (int i = 0; i < 10; i++) {

            int digit = Character.getNumericValue(voteId.charAt(i));

            sum1 += digit * weights1[i];

        }

        int remainder1 = sum1 % 11;

        int check1 = remainder1 == 10 ? 0 : remainder1;


        // Multiplicadores para o segundo dígito verificador
        int[] weights2 = { 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9 };

        int sum2 = 0;

        // Calcula o segundo dígito verificador
        for (int i = 0; i < 10; i++) {

            int digit = Character.getNumericValue(voteId.charAt(i));
            sum2 += digit * weights2[i];

        }

        sum2 += check1 * weights2[10];

        int remainder2 = sum2 % 11;

        int check2 = remainder2 == 10 ? 0 : remainder2;

        // Compara os dígitos calculados com os informados
        return check1 == Character.getNumericValue(voteId.charAt(10)) && check2 == Character.getNumericValue(voteId.charAt(11));
    }
}