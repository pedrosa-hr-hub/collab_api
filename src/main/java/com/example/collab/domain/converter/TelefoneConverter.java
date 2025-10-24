package com.example.collab.domain.converter;

import com.example.collab.domain.Telefone;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TelefoneConverter implements AttributeConverter<Telefone, String> {

    @Override
    public String convertToDatabaseColumn(Telefone attribute) {
        return attribute != null ? attribute.getNumero() : null;
    }

    @Override
    public Telefone convertToEntityAttribute(String dbData) {
        return dbData != null ? new Telefone(dbData) : null;
    }
}