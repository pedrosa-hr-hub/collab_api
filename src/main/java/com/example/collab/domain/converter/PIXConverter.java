package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.banking.PIX;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PIXConverter implements AttributeConverter<PIX, String> {

    @Override
    public String convertToDatabaseColumn(PIX attribute) {
        return attribute != null ? attribute.getChave() : null;
    }

    @Override
    public PIX convertToEntityAttribute(String dbData) {
        return dbData != null ? new PIX(dbData) : null;
    }
}