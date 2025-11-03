package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.contato.Phone;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PhoneConverter implements AttributeConverter<Phone, String> {

    @Override
    public String convertToDatabaseColumn(Phone attribute) {
        return attribute != null ? attribute.getNumber() : null;
    }

    @Override
    public Phone convertToEntityAttribute(String dbData) {
        return dbData != null ? new Phone(dbData) : null;
    }
}