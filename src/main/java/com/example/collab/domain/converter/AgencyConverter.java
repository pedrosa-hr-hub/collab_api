package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.banking.Agency;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AgencyConverter implements AttributeConverter<Agency, String> {

    @Override
    public String convertToDatabaseColumn(Agency attribute) {

        return attribute != null ? attribute.getNumber() : null;

    }

    @Override
    public Agency convertToEntityAttribute(String dbData) {
        return dbData != null ? new Agency(dbData) : null;
    }
}