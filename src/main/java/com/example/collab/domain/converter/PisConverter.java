package com.example.collab.domain.converter;

import com.example.collab.domain.PIS;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PisConverter implements AttributeConverter<PIS, String> {

    @Override
    public String convertToDatabaseColumn(PIS attribute) {
        return attribute != null ? attribute.getPis() : null;
    }

    @Override
    public PIS convertToEntityAttribute(String dbData) {
        return dbData != null ? new PIS(dbData) : null;
    }
}