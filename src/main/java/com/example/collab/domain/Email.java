package com.example.collab.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Value
@Getter
@Setter
public class Email {
    String email;

    public Email(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("E-mail deve ser informado");
        }
        if (!isValid(email)) {
            throw new IllegalArgumentException("Formato inválido: " + email);
        }

        this.email = email;
    }

    private boolean isValid(String email) {
        try {

            InternetAddress address = new InternetAddress(email);

            address.validate();

            return true;

        } catch (AddressException ex) {

            return false;

        }
    }
}
