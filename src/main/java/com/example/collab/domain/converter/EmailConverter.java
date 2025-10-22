package com.example.collab.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.example.collab.domain.Email;

@Converter(autoApply = true)
public class EmailConverter implements AttributeConverter<Email, String> {

    @Override
    public String convertToDatabaseColumn(Email attribute) {
        return attribute != null ? attribute.getEmail() : null;
    }

    @Override
    public Email convertToEntityAttribute(String dbData) {
        return dbData != null ? new Email(dbData) : null;
    }
}